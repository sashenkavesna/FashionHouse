package com.example.fashionhouse;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class WardrobeParser extends AsyncTask<Void, Void, Wardrobe> {
    Context context;
    Wardrobe wardrobe;
    TasksGenerator generator;

    WardrobeParser(Context cntxt, TasksGenerator generator) {
        wardrobe = new Wardrobe();
        context = cntxt;
        this.generator = generator;
    }

    @Override
    protected Wardrobe doInBackground(Void... voides) {
        try {
            parseWardrobe();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wardrobe;
    }

    protected void parseWardrobe() throws XmlPullParserException, IOException {
        XmlPullParser parser = context.getResources().getXml(R.xml.wardrobe);
        if (parser.getEventType() == XmlPullParser.START_DOCUMENT) {
            parser.next();
            parser.next();
            if (parser.getEventType() == XmlPullParser.START_TAG && parser.getName().equals("wardrobe")) {
                parser.next();
                while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                    if (parser.getEventType() == XmlPullParser.START_TAG && parser.getName().equals("clothes")) {
                        Clothes clothes = new Clothes();
                        clothes.setContext(context);
                        clothes.setType(parser.getAttributeValue(0));
                        parser.next();
                        while (parser.getEventType() == XmlPullParser.START_TAG && !parser.getName().equals("clothes")) {
                            if (parser.getName().equals("name")) {
                                parser.next();
                                clothes.setName(parser.getText());
                                parser.next();
                            } else if (parser.getName().equals("tissue")) {
                                clothes.setColor(parser.getAttributeValue(0));
                                generator.addColors(parser.getAttributeValue(0));
                                clothes.setPrint(parser.getAttributeValue(1));
                                generator.addPrints(parser.getAttributeValue(1));
                                parser.next();
                                clothes.setTissue(parser.getText());
                                generator.addTissue(parser.getText());
                                parser.next();
                            } else if (parser.getName().equals("img")) {
                                parser.next();
                                clothes.setImgId(parser.getText());
                                parser.next();
                            } else if (parser.getName().equals("style")) {
                                parser.next();
                                clothes.setStyle(parser.getText());
                                generator.addStyle(parser.getText());
                                parser.next();
                                parser.next();
                            }
                            parser.next();
                        }
                        wardrobe.addClothes(clothes);
                    } else {
                        break;
                    }
                }

            }

        }
    }
}
