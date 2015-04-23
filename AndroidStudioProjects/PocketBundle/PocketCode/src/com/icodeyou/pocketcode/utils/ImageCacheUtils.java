package com.icodeyou.pocketcode.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.icodeyou.pocketcode.MainActivity;
import com.icodeyou.pocketcode.R;

public class ImageCacheUtils {
	private String mSavePath;
	private Context mContext;
	private String lesson_path;
	private String lesson_name;

	public ImageCacheUtils(Context context, String lesson_path,
			String lesson_name) {
		this.mContext = context;
		this.lesson_name = lesson_name;
		this.lesson_path = lesson_path;
	}

	public void downloadImage() {
		new downloadImageThread().start();
	}
	
	public void downloadAndSetImage(ImageView imageView) {
		new downloadAndSetImageThread(imageView).start();
	}
	
	public boolean isImageExists() {
		try {
			// 判断SD卡是否存在，并且是否具有读写权限
			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				// 获得存储卡的路径
				String sdpath = Environment.getExternalStorageDirectory() + "/";
				mSavePath = sdpath + "PocketCodeImages";
				// 创建连接
				File imageFile = new File(mSavePath, lesson_name + ".jpg");
				// 判断文件是否存在
				if (imageFile.exists()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private class downloadImageThread extends Thread {
		@Override
		public void run() {
			try {
				// 判断SD卡是否存在，并且是否具有读写权限
				if (Environment.getExternalStorageState().equals(
						Environment.MEDIA_MOUNTED)) {
					// 获得存储卡的路径
					String sdpath = Environment.getExternalStorageDirectory()
							+ "/";
					mSavePath = sdpath + "PocketCodeImages";
					URL url = new URL(lesson_path);
					// 创建连接
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.connect();
					// 获取文件大小
					int length = conn.getContentLength();
					// 创建输入流
					InputStream is = conn.getInputStream();

					File file = new File(mSavePath);
					// 判断文件目录是否存在
					if (!file.exists()) {
						file.mkdir();
					}
					File imageFile = new File(mSavePath, lesson_name + ".jpg");
					FileOutputStream fos = new FileOutputStream(imageFile);
					int count = 0;
					// 缓存
					byte buf[] = new byte[1024];
					// 写入到文件中
					do {
						int numread = is.read(buf);
						count += numread;
						if (numread <= 0) {
							break;
						}
						// 写入文件
						fos.write(buf, 0, numread);
					} while (true);
					fos.close();
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	private class downloadAndSetImageThread extends Thread {
		public ImageView imageView;
		public downloadAndSetImageThread(ImageView imageView){
			this.imageView = imageView;
		}
		
		@Override
		public void run() {
			try {
					URL url = new URL(lesson_path);
					// 创建连接
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.connect();
					// 获取文件大小
					int length = conn.getContentLength();
					// 创建输入流
					InputStream is = conn.getInputStream();
					Bitmap bitmap = BitmapFactory.decodeStream(is);
					imageView.setImageBitmap(bitmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

}