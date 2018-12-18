package com.example.riadul.tobangla;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by Riadul on 4/6/2018.
 */
public class ToBangla extends AppCompatActivity {
    private ToEnglish ojToEnglish;
    private EditText inputNumber;
    private TextView outputNumber,outputNumberEnglish;
    private Button coppyButton,coppyButtonEnglish;
    private String s1 = "",s2 = "", point = "";
    private String banglaNumberList[] = {"শুন্য", "এক", "দুই", "তিন", "চার", "পাঁচ", "ছয়", "সাত", "আট", "নয়", "দশ", "এগারো", "বারো", "তেরো",
            "চৌদ্দ", "পনেরো", "ষোল", "সতেরো", "আঠারো", "ঊনিশ", "বিশ", "একুশ", "বাইশ", "তেইশ", "চব্বিশ", "পঁচিশ", "ছাব্বিশ",
            "সাতাশ", "আঠাশ", "ঊনত্রিশ", "ত্রিশ", "একত্রিশ", "বত্রিশ", "তেত্রিশ", "চৌত্রিশ", "পঁয়ত্রিশ", "ছত্রিশ", "সাইত্রিশ", "আটত্রিশ",
            "ঊনচল্লিশ", "চল্লিশ", "একচল্লিশ", "বিয়াল্লিশ", "তেতাল্লিশ", "চুয়াল্লিশ", "পঁয়তাল্লিশ", "ছেচল্লিশ", "সাতচল্লিশ", "আটচল্লিশ",
            "ঊনপঞ্চাশ", "পঞ্চাশ", "একান্ন", "বাআন্ন", "তেপ্পান্ন", "চুয়ান্নও", "পঞ্চান্ন", "ছাপ্পান্ন", "সাতান্ন", "আটান্ন", "ঊনষাট", "ষাট",
            "একষট্টি", "বাষট্টি", "তেষট্টি", "চৌষট্টি", "পইসটি", "ছেষট্টি", "সাতষট্টি", "আটষট্টি", "উনসত্তর", "সত্তর", "একাত্তর",
            "বাহাত্তর", "তেহাত্তর", "চুহাত্তর", "পচাত্তর", "সিয়াত্তর", "সাতাত্তর", "আটাত্তর", "উনআশি", "আশি", "একাশি", "বিরাশি",
            "তিরাশি", "চুরাশি", "পঁচাশি", "ছিআশি", "সাতাশি", "আটাশি", "ঊনানব্বই", "নব্বই", "একানব্বই", "বিরানব্বই",
            "তিরানব্বই", "চুরানব্বই", "পঁচানব্বই", "ছিয়ানব্বই,", "সাতানব্বই", "আটানব্বই", "নিরানব্বই"};
    private String banglaNumber1[] = {"০", "১", "২", "৩", "৪", "৫", "৬", "৭", "৮", "৯"};
    private String banglaNumber2[] = {"", "০১", "০২", "০৩", "০৪", "০৫", "০৬", "০৭", "০৮", "০৯", "১০", "১১", "১২", "১৩", "১৪", "১৫", "১৬", "১৭", "১৮", "১৯",
            "২০", "২১", "২২", "২৩", "২৪", "২৫", "২৬", "২৭", "২৮", "২৯", "৩০", "৩১", "৩২", "৩৩", "৩৪", "৩৫", "৩৬", "৩৭", "৩৮", "৩৯",
            "৪০", "৪১", "৪২", "৪৩", "৪৪", "৪৫", "৪৬", "৪৭", "৪৮", "৪৯", "৫০", "৫১", "৫২", "৫৩", "৫৪", "৫৫", "৫৬", "৫৭", "৫৮", "৫৯",
            "৬০", "৬১", "৬২", "৬৩", "৬৪", "৬৫", "৬৬", "৬৭", "৬৮", "৬৯", "৭০", "৭১", "৭২", "৭৩", "৭৪", "৭৫", "৭৬", "৭৭", "৭৮", "৭৯",
            "৮০", "৮১", "t৮২", "৮৩", "৮৪", "৮৫", "৮৬", "৮৭", "৮৮", "৮৯", "৯০", "৯১", "৯২", "৯৩", "৯৪", "৯৫", "৯৬", "৯৭", "৯৮", "৯৯"};
    private String number1[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String number2[] = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
            "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
            "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65",
            "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87",
            "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_bangla);
        ojToEnglish=new ToEnglish();
        getNumber();
    }

    public void getNumber() {
        inputNumber = (EditText) findViewById(R.id.inputNumber);
        outputNumber = (TextView) findViewById(R.id.outputNumber);
        outputNumberEnglish = (TextView) findViewById(R.id.outputNumberEnglish);


        inputNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                NumberShow(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void NumberShow(String s)
    {
        s1 = "";
        point = "";
        String temp = s;
        s2=ojToEnglish.GetInputNumber(s);
        if (temp.indexOf(".") != -1) {
            point = " দশমিক ";
            temp = point(temp);
        }
        else
        {
            point = "";
        }
        s1 = ConvertToBangla(temp) + point;
        
        outputNumber.setText(s1);
        outputNumberEnglish.setText(s2);
        coppyNumber();
    }


    public String ConvertToBangla(String temp)
    {

        int len = temp.length();
        double n = len / 17;
        int tempLen = 0;
        String s1 = "";
        if (len <= 17) {
            s1 = toBanglaNumber(temp);
        } else {
            n = Math.ceil(n);
            for (int i = 0; i <= n; i++) {
                if (i == n)
                {
                    if(toBanglaNumber(temp.substring(0, len)) !="")
                    {
                        s1 = toBanglaNumber(temp.substring(0, len))+"পরার্ধ " + s1;
                    }
                }
                else
                {
                    if(i==0)
                    {
                        s1=toBanglaNumber(temp.substring(len - 17, len))+ s1;
                    }
                    else
                    {
                        s1=toBanglaNumber(temp.substring(len - 17, len))+"পরার্ধ " + s1;
                    }

                    len -= 17;
                }
            }
        }

        
     return s1;
    }
    public String point(String temp) {
        int find = temp.indexOf(".");
        point += ConvertToBangla(temp.substring(find+1, temp.length()));
        return temp.substring(0, find);
    }
    public void coppyNumber() {
        coppyButton = (Button) findViewById(R.id.copyButton);
        coppyButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(s1, s1);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(ToBangla.this, "Copy Bangla Number Successfully", Toast.LENGTH_LONG).show();
            }
        });

        coppyButtonEnglish = (Button) findViewById(R.id.copyButtonEnglish);
        coppyButtonEnglish.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(s2, s2);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(ToBangla.this, "Copy English Number Successfully", Toast.LENGTH_LONG).show();
            }
        });
    }

    public String toBanglaNumber(String s) {
        int ln = s.length();

        if (ln == 1) {
            return zeroToNine(s);
        } else if (ln == 2) {
            return zeroToNintyNine(s);
        } else if (ln == 3) {
            return singleHundred(s);
        } else if (ln == 4) {
            return singleThousand(s);
        } else if (ln == 5) {
            return doubleThousand(s);
        } else if (ln == 6) {
            return singleLuk(s);
        } else if (ln == 7) {
            return doubleLuk(s);
        }
        else if (ln == 8) {
            return singleKoti(s);
        }
        else if (ln == 9) {
            return doubleKoti(s);
        }
        else if (ln == 10) {
            return singlePodo(s);
        }
        else if (ln == 11) {
            return singleKhorbo(s);
        }
        else if (ln == 12) {
            return niKhorbo(s);
        }
        else if (ln == 13) {
            return mohaPoddo(s);
        }
        else if (ln == 14) {
            return sonKu(s);
        }
        else if (ln == 15) {
            return joloDhi(s);
        }
        else if (ln == 16) {
            return annonTo(s);
        }
        else if (ln == 17) {
            return moDho(s);
        }
        else if (ln == 18) {
            return poraDho(s);
        }
        return "";
    }



    public String zeroToNine(String s) {
        for (int i = 1; i < 10; i++) {
            if (s.compareTo(number1[i]) == 0  || s.compareTo(banglaNumber1[i]) == 0 ) {
                return banglaNumberList[i];
            }
        }
        return "";
    }

    public String zeroToNintyNine(String s) {
        for (int i = 0; i < 100; i++) {
            if (s.compareTo(number2[i]) == 0 || s.compareTo(banglaNumber2[i]) == 0) {
                return banglaNumberList[i];
            }
        }
        return "";
    }

    public String singleHundred(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "শো ";
        }
        temp += zeroToNintyNine(s.substring(1, 3));
        return temp;
    }

    public String singleThousand(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "হাজার ";
        }
        temp += singleHundred(s.substring(1, 4));
        return temp;
    }

    public String doubleThousand(String s) {
        String temp = "";
        temp += zeroToNintyNine(s.substring(0, 2));
        if (s.substring(0, 2).compareTo("00") != 0) {
            temp += "হাজার ";
        }
        temp += singleHundred(s.substring(2, 5));
        return temp;
    }

    public String singleLuk(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "লাখ ";
        }
        temp += doubleThousand(s.substring(1, 6));
        return temp;
    }

    public String doubleLuk(String s) {
        String temp = "";
        temp += zeroToNintyNine(s.substring(0, 2));
        if (s.substring(0, 2).compareTo("00") != 0) {
            temp += "লাখ ";
        }
        temp += doubleThousand(s.substring(2, 7));
        return temp;
    }

    public String singleKoti(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "কোটি ";
        }
        temp += doubleLuk(s.substring(1, 8));
        return temp;
    }

    public String doubleKoti(String s) {
        String temp = "";
        temp += zeroToNintyNine(s.substring(0, 2));
        if (s.substring(0, 2).compareTo("00") != 0) {
            temp += "কোটি ";
        }
        temp += doubleLuk(s.substring(2, 9));
        return temp;
    }

    public String singlePodo(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "পদ্ম ";
        }
        temp += doubleKoti(s.substring(1, 10));
        return temp;
    }

    public String singleKhorbo(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "খর্ব ";
        }
        temp += singlePodo(s.substring(1, 11));
        return temp;
    }

    public String niKhorbo(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "নিখর্ব ";
        }
        temp += singleKhorbo(s.substring(1, 12));
        return temp;
    }

    public String mohaPoddo(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "মহাপদ্ধ ";
        }
        temp += niKhorbo(s.substring(1, 13));
        return temp;
    }

    public String sonKu(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "শঙ্কু ";
        }
        temp += mohaPoddo(s.substring(1, 14));
        return temp;
    }

    public String joloDhi(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "জলধি ";
        }
        temp += sonKu(s.substring(1, 15));
        return temp;
    }

    public String annonTo(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "অন্ত্য ";
        }
        temp += joloDhi(s.substring(1, 16));
        return temp;
    }

    public String moDho(String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "মধ্য ";
        }
        temp += annonTo(s.substring(1, 17));
        return temp;
    }

    public String poraDho (String s) {
        String temp = "";
        temp += zeroToNine(s.substring(0, 1));
        if (s.substring(0, 1).compareTo("0") != 0) {
            temp += "পরার্ধ ";
        }
        temp += moDho(s.substring(1, 18));
        return temp;
    }

}
