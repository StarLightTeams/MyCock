package cn.tedu.test;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;
	private RadioGroup radioGroup;
	private RadioButton radioButton1;
	private RadioButton radioButton2;
	private List<Fragment> fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setViews();
		setPagerAdapters();
		setListener();
	}

	private void setPagerAdapters() {
		fragment = new ArrayList<Fragment>();
		fragment.add(new Fragment1());
		fragment.add(new Fragment2());
		PagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);

	}

	class MainPagerAdapter extends FragmentPagerAdapter {

		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int postion) {
			return fragment.get(postion);
		}

		@Override
		public int getCount() {
			return fragment.size();
		}

	}

	@SuppressWarnings("deprecation")
	private void setListener() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					radioButton1.setChecked(true);
					Log.i("info", "这个是第一页");
					break;

				case 1:
					radioButton2.setChecked(true);
					Log.i("info", "这个是第二页");
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_1:
					viewPager.setCurrentItem(0);
					break;

				case R.id.rb_2:
					viewPager.setCurrentItem(1);
					break;
				}
			}
		});
	}

	public void setViews() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		radioButton1 = (RadioButton) findViewById(R.id.rb_1);
		radioButton2 = (RadioButton) findViewById(R.id.rb_2);
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
	}

}
