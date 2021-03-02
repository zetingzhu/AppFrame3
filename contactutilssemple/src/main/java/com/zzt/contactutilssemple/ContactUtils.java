package com.zzt.contactutilssemple;

import android.database.sqlite.SQLiteCursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.provider.ContactsContract.CommonDataKinds.Nickname;
import android.provider.ContactsContract.CommonDataKinds.Note;
import android.provider.ContactsContract.CommonDataKinds.Organization;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: zeting
 * @date: 2020/12/8
 * 获取通讯录工具类
 * 返回的数据：
 * [{
 * "name": "xxx",
 * "note": "呵呵呵呵",
 * "phone": "13333333332"
 * },
 * {
 * "name": "yyy",
 * "phone": "13333333333"
 * },
 * {
 * "name": "zzz",
 * "phone": "13333333334"
 * },
 * ......
 * ]
 */
public class ContactUtils {
    final static String TAG = ContactUtils.class.getSimpleName();
    public static ArrayList<MyContacts> getAllContacts(Context context) {
        // 获得所有的联系人
        Cursor cur = context.getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME
                        + " COLLATE LOCALIZED ASC");
        ArrayList<MyContacts> contactList = new ArrayList<MyContacts>();
        if (cur.moveToFirst()) {
            int idColumn = cur.getColumnIndex(ContactsContract.Contacts._ID);
            int displayNameColumn = cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            do {
                MyContacts contact = new MyContacts();
                // 获得联系人的ID号
                String contactId = cur.getString(idColumn);
                // 联系人分组信息
                int nameRawContactId = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    nameRawContactId = cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.NAME_RAW_CONTACT_ID));
                }
                // 获得联系人姓名
                contact.setName(cur.getString(displayNameColumn));

                // 查看该联系人有多少个电话号码。如果没有这返回值为0
                int phoneCount = cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                if (phoneCount > 0) {
                    // 获得联系人的电话号码
                    Cursor phones = context.getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                    + " = " + contactId, null, null);
                    if (phones.moveToFirst()) {
                        List<String> phoneList = new ArrayList<>();
                        do {
                            // 遍历所有的电话号码
                            String phoneNumber = phones
                                    .getString(phones
                                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            phoneList.add(phoneNumber);
                        } while (phones.moveToNext());
                        contact.setPhone(phoneList);
                        phones.close();
                    }
                }
                // 获取该联系人组织
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    String selection2 = Data.NAME_RAW_CONTACT_ID + "=?" + " AND " + Data.MIMETYPE + "='"
                            + ContactsContract.CommonDataKinds.GroupMembership.CONTENT_ITEM_TYPE + "'";
                    Cursor organizations = context.getContentResolver().query(
                            Data.CONTENT_URI, null,
                            selection2,
                            new String[]{String.valueOf(nameRawContactId)}, null);
                    if (organizations.moveToFirst()) {
                        List<String> groupList = new ArrayList<>();
                        do {
                            // 获取分组id
                            String data1 = organizations.getString(organizations.getColumnIndex(Data.DATA1));
                            // 获取联系人组
                            Cursor cursorgroups = context.getContentResolver().query(ContactsContract.Groups.CONTENT_URI,
                                    null, ContactsContract.Groups._ID + "=?", new String[]{data1}, null, null);
                            if (cursorgroups.moveToFirst()) {
                                do {
                                    String groupName = cursorgroups.getString(cursorgroups.getColumnIndex(ContactsContract.Groups.TITLE)); // 组名
                                    groupList.add(groupName);
                                } while (cursorgroups.moveToNext());
                                cursorgroups.close();
                            }

                        } while (organizations.moveToNext());
                        contact.setGroup(groupList);
                        organizations.close();
                    }
                }
                contactList.add(contact);
            } while (cur.moveToNext());
            cur.close();
        }
        return contactList;
    }


}
