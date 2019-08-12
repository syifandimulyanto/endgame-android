package id.endgame.app.ui.main.home;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.Target;
import id.endgame.app.R;
import id.endgame.app.data.entity.model.Slider;

/**
 * Created by syifandimulyanto.id on 2019-08-09
 */
public final class ImageSliderFragment extends Fragment implements View.OnClickListener {
    private static final String KEY_CONTENT = "ImageSliderFragment:image";

    private Slider imageData;
    private ImageView imageView;

    public static ImageSliderFragment newInstance(Slider imageData) {
        ImageSliderFragment fragment = new ImageSliderFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CONTENT, imageData);

        fragment.setArguments(bundle);
        fragment.imageData = imageData;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageData = (Slider) getArguments().getSerializable(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        imageView = new ImageView(getActivity());
        imageView.setOnClickListener(this);

        // Add this code for imageView wrapping content
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAdjustViewBounds(true);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(imageView);
        Glide.with(imageView.getContext())
                .load(imageData.getUrl())
                .error(R.drawable.ic_logo)
                .placeholder(R.drawable.ic_logo)
                .transform(new RoundedCorners(15))
                .override(Target.SIZE_ORIGINAL)
                .into(imageView);
        return layout;
    }

    @Override
    public void onClick(View view) {

    }
}
