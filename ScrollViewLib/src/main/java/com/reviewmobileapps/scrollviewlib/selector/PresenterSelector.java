package com.reviewmobileapps.scrollviewlib.selector;

import com.reviewmobileapps.scrollviewlib.presenter.Presenter;

/**
 * Define API for all selector presenters which select presenter for each item
 * in {@link com.reviewmobileapps.scrollviewlib.CustomScrollView}
 */
public interface PresenterSelector {

    Presenter getPresenter(int viewType);
}
