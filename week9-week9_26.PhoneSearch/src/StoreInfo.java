/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuwei Zhong
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.LinkedHashSet;

public class StoreInfo {

    private Map<String, List<String>> namePhoneMap;
    private Map<String, String> phoneNameMap;
    private Map<String, String> nameAddressMap;

    public StoreInfo() {
        this.namePhoneMap = new HashMap<String, List<String>>();
        this.phoneNameMap = new HashMap<String, String>();
        this.nameAddressMap = new HashMap<String, String>();
    }

    public void command1(String name, String phone) {
        if (!this.namePhoneMap.keySet().contains(name)) {
            List<String> phoneList = new ArrayList<String>();
            phoneList.add(phone);
            this.namePhoneMap.put(name, phoneList);
        } else {
            this.namePhoneMap.get(name).add(phone);
        }
        this.phoneNameMap.put(phone, name);
    }

    public void command2(String name) {
        if (!this.namePhoneMap.containsKey(name)) {
            System.out.println("  not found");
        } else {
            List<String> list = this.namePhoneMap.get(name);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(" " + list.get(i));
            }
        }
    }

    public void command3(String phone) {
        if (!this.phoneNameMap.containsKey(phone)) {
            System.out.println("  not found");
        } else {
            System.out.println(" " + this.phoneNameMap.get(phone));
        }
    }

    public void command4(String name, String address) {
        this.nameAddressMap.put(name, address);
    }

    public void command5(String name) {
        if (!this.nameAddressMap.containsKey(name)
                && !this.namePhoneMap.containsKey(name)) {
            System.out.println("  not found");
            return;
        }
        if (!this.nameAddressMap.containsKey(name)) {
            System.out.println("  address unknown");
        } else {
            System.out.println("  address: " + this.nameAddressMap.get(name));
        }

        if (!this.namePhoneMap.containsKey(name)) {
            System.out.println("  phone number not found");
        } else {
            List<String> list = this.namePhoneMap.get(name);
            System.out.println("  phone numbers:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("   " + list.get(i));
            }
        }
    }

    public void command6(String name) {
        this.namePhoneMap.remove(name);
        while (this.phoneNameMap.values().remove(name));
        this.nameAddressMap.remove(name);
    }

    public void command7(String keyword) {
        List<String> names = new ArrayList<String>();
        for (String number : this.phoneNameMap.keySet()) {
            if (number.contains(keyword)) {
                names.add(this.phoneNameMap.get(number));
            }
        }

        for (String name : this.namePhoneMap.keySet()) {
            if (name.contains(keyword)) {
                names.add(name);
            }
        }

        for (String name : this.nameAddressMap.keySet()) {
            if (name.contains(keyword)) {
                names.add(name);
            }
            if (this.nameAddressMap.get(name).contains(keyword)) {
                names.add(name);
            }
        }

        names = new ArrayList<String>(new LinkedHashSet<String>(names));
        Collections.sort(names);

        if (names.isEmpty()) {
            System.out.println(" keyword not found");
        } else {
            for (String name : names) {
                System.out.println("");
                System.out.println(" " + name);
                command5(name);
            }
        }

    }
}
