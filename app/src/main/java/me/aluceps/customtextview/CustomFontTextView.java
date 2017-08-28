package me.aluceps.customtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;

public class CustomFontTextView extends AppCompatTextView {

    private static final String TAG = CustomFontTextView.class.getSimpleName();

    public CustomFontTextView(Context context) {
        this(context, null);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        if (typedArray != null) {
            String asset = typedArray.getString(R.styleable.CustomFontTextView_typeface);
            if (!TextUtils.isEmpty(asset)) {
                int style = Typeface.NORMAL;
                if (getTypeface() != null) {
                    style = getTypeface().getStyle();
                }

                FontManager.init(context.getAssets());
                Typeface typeface = FontManager.getInstance().get(asset);
                if (typeface != null) {
                    setTypeface(typeface, style);
                } else {
                    Log.d(TAG, String.format("Could not create a font from asset: %s", asset));
                }
            }
        }
    }
}
