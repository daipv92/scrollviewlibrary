package com.reviewmobileapps.scrollviewlib.items;

public class ImageButtonItem extends SelectableItem {

    private final int mBackgroundResource;

    private final Type mType;

    public ImageButtonItem(int backgroundResource, Type type) {
        mBackgroundResource = backgroundResource;
        mType = type;
    }

    public int getBackgroundResource() {
        return mBackgroundResource;
    }

    @Override
    public Type getType() {
        return mType;
    }

    @Override
    public ViewType getViewType() {
        return ViewType.IMAGE_BUTTON;
    }
}
