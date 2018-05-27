package com.reviewmobileapps.scrollviewlib.items;

public class ThumbnailWithTitleCardItem extends SelectableItem {

    /**
     * This is thumbnail resource.
     */
    private final int mBackgroundResource;

    private final Type mType;

    private int mTitleResource;

    /**
     * Constructor.
     * @param backgroundResource
     * @param Type
     * @param titleResource
     */
    public ThumbnailWithTitleCardItem(int backgroundResource, Type Type, int titleResource) {
        mBackgroundResource = backgroundResource;
        mType = Type;
        mTitleResource = titleResource;
    }

    public int getBackgroundResource() {
        return mBackgroundResource;
    }

    public int getTitleResource() {
        return mTitleResource;
    }

    @Override
    public Type getType() {
        return mType;
    }

    @Override
    public ViewType getViewType() {
        return ViewType.THUMBNAIL;
    }
}
