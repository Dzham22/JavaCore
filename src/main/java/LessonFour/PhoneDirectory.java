package LessonFour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneDirectory {

        private HashMap<String, HashSet<String>> phoneDirectory = new HashMap<>();

        public void addElementToPhoneDirectory (String contact, String contactNumber){
            HashSet<String> phones;
            if (phoneDirectory.containsKey(contact)){
                phones = phoneDirectory.get(contact);
            }
            else {
                phones = new HashSet<>();
            }
            phones.add(contactNumber.replaceAll(" ",""));
            phoneDirectory.put(contact,phones);
        }

        public Set<String> getPhonesByContact (String contact){
            return phoneDirectory.get(contact);
        }

    }



