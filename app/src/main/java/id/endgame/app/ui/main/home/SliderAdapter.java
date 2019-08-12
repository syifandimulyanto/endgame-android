package id.endgame.app.ui.main.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import id.endgame.app.data.entity.model.Slider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syifandimulyanto.id on 2019-08-09
 */
public class SliderAdapter extends FragmentStatePagerAdapter {

    private List<Slider> banners = new ArrayList<>();
    public static int LOOPS_COUNT = 10000;

    public SliderAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setMenuList(List<Slider> banners) {
        this.banners = banners;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return ImageSliderFragment.newInstance(banners.get(position));
    }

    @Override
    public int getCount() {
        return banners.size();
    }

}
