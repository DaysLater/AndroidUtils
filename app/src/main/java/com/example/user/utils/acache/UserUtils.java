package com.example.user.utils.acache;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserUtils {
	// 保存用户信息的业务方法
	public static boolean saveInfo(Context context, String name,
								   String word) {
		try {
			//得到nanme和word
			String result = name + "###" + word;
			//得到路徑
			String path = context.getFilesDir().getPath();
			//创建file对象
			File file = new File(path, "user.text");
			//获取文件输出流
			FileOutputStream fos = new FileOutputStream(file);
			//写入结果
			fos.write(result.getBytes());
			//关闭流
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//读取用户信息的方法
	public static Map<String, String> readInfo(Context context){
		try{//创建map对象
			Map<String, String> map = new HashMap<String, String>();
			//获取文件路径
			String path = context.getFilesDir().getPath();
			//创建file对象
			File file = new File(path,"user.text");
			//创建输入流
			FileInputStream fis = new FileInputStream(file);
			//创建读取方法
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			//获取读取的内容
			String line = br.readLine();
			String[] split = line.split("###");
			//获取name
			String name = split[0];
			//获取password
			String word = split[1];
			//把name和password存到map中
			map.put("name", name);
			map.put("word", word);
			//返回map
			return map;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

