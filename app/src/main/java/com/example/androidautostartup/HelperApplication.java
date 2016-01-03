package com.example.androidautostartup;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HelperApplication {

	private static final String SHARED_PREF_NAME = "security";
	private static final String GET_SHARED_PREF_RECORD = "security_record";

	public static void setSecurity(Context context, AnswerQuestion answerQuestion) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();

		String strObject = "";
		if (answerQuestion != null) {
			try {
				strObject = objectToString(answerQuestion);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		editor.putString(GET_SHARED_PREF_RECORD, strObject);
		editor.commit();
	}

	public static AnswerQuestion getSecurity(Context context) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, 0);
		String strObject = sharedPreferences.getString(GET_SHARED_PREF_RECORD, "");

		AnswerQuestion answerQuestion = new AnswerQuestion();
		try {
			answerQuestion = (AnswerQuestion) StringToObject(strObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answerQuestion;
	}

	public static String objectToString(Serializable serializableObject) throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(serializableObject);
		objectOutputStream.close();
		return new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
	}

	public static Object StringToObject(String str) throws Exception {
		byte[] data = Base64.decode(str, 0);
		ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return object;
	}

}
