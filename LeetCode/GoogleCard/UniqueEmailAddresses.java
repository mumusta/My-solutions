package com.mumusta.googlecard;

import java.util.HashSet;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 10/08/2022
 *
 * We are going to ignore any chars after the plus sign and all the dots in the local part, it's an implementation problem.
 *
 * Took me 20 minutes to solve it from the first try.
 **/

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {

        HashSet < String > uniqueEmails = new HashSet<>();

        for (int i = 0; i < emails.length; i ++){

            String email = emails[i];

            boolean isDomain = false, ignoreLoacal = false;
            StringBuilder str = new StringBuilder();

            for (int ii = 0; ii < email.length(); ii ++){

                if (email.charAt(ii) == '@'){

                    str.append('@');
                    isDomain = true;
                    continue;
                }

                if (!isDomain){

                    if (ignoreLoacal || email.charAt(ii) == '.'){

                        continue;
                    }

                    if (email.charAt(ii) == '+'){

                        ignoreLoacal = true;

                        continue;
                    }

                    str.append(email.charAt(ii));
                }

                else {

                    str.append(email.charAt(ii));
                }
            }

            uniqueEmails.add(str.toString());
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {

        System.out.println(numUniqueEmails( new String[]{ "a@m.m","c++@le.et.co.de.c.o.m","c@le.et.co.de.c.o.m" } ));
    }
}
