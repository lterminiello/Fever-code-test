package com.lterminiello.ferverstar.viewmodel.list;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.lterminiello.ferverstar.model.Member;

public class MemberListItemViewModel extends BaseObservable {

    private Member member;

    public MemberListItemViewModel(Member member) {
        this.member = member;
        notifyChange();
    }

    public String getTitle() {
        return String.valueOf(member.getId());
    }

    public String getRace() {
        return member.getRaceName();
    }

    @BindingAdapter({ "bind:color" })
    public static void loadImage(ImageView view, int color) {
        view.setBackgroundColor(color);
    }

    public int getColor() {
        return member.getArea().getColor();
    }

    public String getMultiply() {
        return "x" + String.valueOf(member.getMultiplierRace());
    }


    public void setMember(Member member) {
        this.member = member;
        notifyChange();
    }

    public Member getResult() {
        return member;
    }

}
