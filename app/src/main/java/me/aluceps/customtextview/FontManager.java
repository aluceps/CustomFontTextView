package me.aluceps.customtextview;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

class FontManager {

    private static FontManager instance;

    private AssetManager manager;

    private Map<String, Typeface> fonts;

    private FontManager(AssetManager _manager) {
        manager = _manager;
        fonts = new HashMap<>();
    }

    static void init(AssetManager manager) {
        if (instance == null) {
            instance = new FontManager(manager);
        }
    }

    static FontManager getInstance() {
        return instance;
    }

    Typeface get(String asset) {
        if (fonts.containsKey(asset)) {
            return fonts.get(asset);
        }

        Typeface font = Typeface.createFromAsset(manager, asset);
        fonts.put(asset, font);

        return font;
    }
}
