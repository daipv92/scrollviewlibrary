package com.reviewmobileapps.scrollviewlib.selector;

import com.reviewmobileapps.scrollviewlib.items.IScrollViewItem;
import com.reviewmobileapps.scrollviewlib.presenter.ImageButtonPresenter;
import com.reviewmobileapps.scrollviewlib.presenter.Presenter;
import com.reviewmobileapps.scrollviewlib.presenter.ThumbnailWithTitleCardPresenter;

import java.util.HashMap;

/**
 * Implement a presenter selector.
 */
public class HorizontalSelector implements PresenterSelector {

    private final HashMap<Integer, Presenter> mPresenterList = new HashMap<>();

    @Override
    public Presenter getPresenter(int viewType) {
        Presenter presenter = mPresenterList.get(viewType);
        if (presenter == null) {
            if (IScrollViewItem.ViewType.IMAGE_BUTTON.ordinal() == viewType) {
                presenter = new ImageButtonPresenter();
            } else if (IScrollViewItem.ViewType.THUMBNAIL.ordinal() == viewType) {
                presenter = new ThumbnailWithTitleCardPresenter();
            }
        }
        return presenter;
    }
}
