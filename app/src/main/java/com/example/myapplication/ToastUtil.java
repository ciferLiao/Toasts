package com.example.myapplication;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/** @Author FangGang
 * 创建日期 2018/4/28 10:05.
 * 文件描述:{@link Toast}提示简单封装
 */
public class ToastUtil {

  private static Toast result;
  private static TextView textView;
  private static ImageView imageView;



  public static void init(Context context) {
    if (result != null) {
      result.cancel();
      result = null;
    }
    result = new Toast(context);

    //获取LayoutInflater对象
    LayoutInflater inflater =
            (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //由layout文件创建一个View对象
    View layout = inflater.inflate(R.layout.view_customtoast, null);

    //实例化ImageView和TextView对象
    textView = layout.findViewById(R.id.text);

    imageView = layout.findViewById(R.id.image);

    imageVisible(false);

    result.setView(layout);
    result.setDuration(Toast.LENGTH_SHORT);
    //        result.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
  }
  /**
   * Toast短提示
   *
   * @param msg 内容
   */
  public static void showShort(String msg) {
    makeText(msg);
  }

  /**
   * Toast短提示
   *
   * @param resId {@link StringRes}
   */
  public static void showShort(@StringRes int resId) {
    makeText(resId);
  }

  /**
   * Toast长提示
   *
   * @param msg 内容
   */
  public static void showLong(String msg) {
    makeText(msg,Toast.LENGTH_LONG);
  }

  /**
   * Toast长提示
   *
   * @param resId 字符串资源id
   */
  public static void showLong(@StringRes int resId) {
    makeText(resId,Toast.LENGTH_LONG);
  }

  public static void showLong(@StringRes int resId, @DrawableRes int res){
    makeTextAndImage(resId,res,Toast.LENGTH_LONG);
  }

  public static void showShort(@StringRes int resId, @DrawableRes int res){
    makeTextAndImage(resId,res);
  }

  public static void showLong(String text , @DrawableRes int res){
    makeTextAndImage(text,res,Toast.LENGTH_LONG);
  }

  public static void showShort(String text , @DrawableRes int res){
    makeTextAndImage(text,res);
  }

  private static void makeText(String text, int duration) {
    if(result == null){
      return;
    }

    imageVisible(false);
    textView.setText(text);
    result.setDuration(duration);
    result.show();
  }

  private static void makeText(@StringRes int text) {
    if(result == null){
      return;
    }
    imageVisible(false);
    textView.setText(text);
    result.show();
  }

  private static void makeText(@StringRes int text, int duration) {
    if(result == null){
      return;
    }

    imageVisible(false);
    textView.setText(text);
    result.setDuration(duration);
    result.show();
  }

  private static void makeText(String text) {
    if(result == null){
      return;
    }
    imageVisible(false);
    textView.setText(text);
    result.show();
  }

  private static void imageVisible(boolean isShow){
    imageView.setVisibility( isShow ? View.VISIBLE : View.GONE);
  }

  private static void makeTextAndImage(String text , @DrawableRes int res ,int duration){
    if(result == null){
      return;
    }
    textView.setText(text);
    imageView.setImageResource(res);
    imageVisible(true);
    result.setDuration(duration);
    result.show();
  }


  private static void makeTextAndImage(String text , @DrawableRes int res){
    if(result == null){
      return;
    }
    textView.setText(text);
    imageView.setImageResource(res);
    imageVisible(true);
    result.show();
  }

  private static void makeTextAndImage(@StringRes int resId, @DrawableRes int res){
    if(result == null){
      return;
    }
    textView.setText(resId);
    imageView.setImageResource(res);
    imageVisible(true);
    result.show();
  }private static void makeTextAndImage(@StringRes int resId,@DrawableRes int res,int duration){
    if(result == null){
      return;
    }
    textView.setText(resId);
    result.setDuration(duration);
    imageView.setImageResource(res);
    imageVisible(true);
    result.show();
  }
}
