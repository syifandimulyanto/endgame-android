package id.endgame.app.utils.view;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.sothree.slidinguppanel.ScrollableViewHelper;

/**
 * Created by @adriyoutomo on 30/06/2019.
 */
public class NestedScrollableViewHelper extends ScrollableViewHelper {
    public int getScrollableViewScrollPosition(View scrollableView, boolean isSlidingUp) {
        if (scrollableView instanceof NestedScrollView) {
            if(isSlidingUp){
                return scrollableView.getScrollY();
            } else {
                NestedScrollView nsv = ((NestedScrollView) scrollableView);
                View child = nsv.getChildAt(0);
                return (child.getBottom() - (nsv.getHeight() + nsv.getScrollY()));
            }
        } else {
            return 0;
        }
    }
}