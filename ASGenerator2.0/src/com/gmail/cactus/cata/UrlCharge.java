package com.gmail.cactus.cata;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlCharge extends Main {

	String chaine;

	public UrlCharge() throws Exception {

		HttpURLConnection conn1 = (HttpURLConnection) new URL(
				"https://sessionserver.mojang.com/session/minecraft/profile/9b8d31d5420c4f0c80f0de834b737a99")
						.openConnection();
		conn1.connect();

		BufferedInputStream bis = new BufferedInputStream(conn1.getInputStream());

		byte[] bytes = new byte[1024];
		int tmp;
		while ((tmp = bis.read(bytes)) != -1) {
			chaine = new String(bytes, 0, tmp);
			System.out.print(chaine + "\n\n");
		}

	}

}
