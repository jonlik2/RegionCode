package com.jonli.regioncode.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.jonli.regioncode.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jonli on 29.11.2017.
 */

public class CodeModel implements Model {

    private Context mContext;

    private Map<String, String> data = new HashMap<>();

    public CodeModel(Context context) {
        mContext = context;
        init();
    }

    private void init() {
        try {
            XmlPullParser parser = mContext.getResources().getXml(R.xml.data);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (parser.getEventType()) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("code")) {
                            String code = parser.getAttributeValue(0);
                            if (code.length() == 1) code = String.format("0%s", code);
                            String value = parser.nextText();
                            data.put(code, value);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        break;
                    default:
                        break;
                }
                parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Ошибка при загрузке XML-документа", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Map<String, String> getData() {
        return data;
    }


}
