package com.example.celebrare_assigment;

import android.graphics.Typeface;

public class Text {
    int size;
    String text;
    Typeface font;
    int font_pos;
    int color;
    int color_pos;
    public Text(int size, String text, Typeface font, int font_pos, int color, int color_pos) {
        this.size = size;
        this.text = text;
        this.color = color;
        this.font = font;
        this.font_pos = font_pos;
        this.color_pos = color_pos;
    }

}
