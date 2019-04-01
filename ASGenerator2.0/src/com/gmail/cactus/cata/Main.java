package com.gmail.cactus.cata;

import java.util.Scanner;

import com.gmail.cactus.cata.ArmorStand.DataTag;
import com.gmail.cactus.cata.ArmorStand.RotationType;

public class Main {

	public static void main(String[] args) throws Throwable {
		ArmorStand as = new ArmorStand();
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"----------------------------------------------------------------------------------\n				ArmorStand Generator			\n----------------------------------------------------------------------------------\nConfiguration de l'ArmorStand");
		as.setDataTag(DataTag.CustomNameVisible, 0);
		as.setDataTag(DataTag.DisabledSlots, 2039583);
		as.setDataTag(DataTag.Invisible, 0);
		as.setDataTag(DataTag.Invulnerable, 1);
		as.setDataTag(DataTag.NoBasePlate, 1);
		as.setDataTag(DataTag.NoGravity, 0);
		as.setDataTag(DataTag.PersistenceRequired, 1);
		as.setDataTag(DataTag.ShowArms, 1);
		as.setDataTag(DataTag.Small, 0);
		System.out.println("Configuration par défaut :");

		as.setRotation(random(-180.0f, 180.0f));
		as.setRotation(RotationType.HEAD, random(-35.0f, 35.0f), random(-60, 60));
		as.setRotation(RotationType.LEFT_LEG, random(-60.0f, 60.0f), random(-30, 30));
		as.setRotation(RotationType.RIGHT_LEG, random(-60.0f, 60.0f), random(-30, 30));
		as.setRotation(RotationType.LEFT_ARM, random(-145.0f, 30.0f), random(-45.0f, 45.0f));
		as.setRotation(RotationType.RIGHT_ARM, random(-145.0f, 30.0f), random(-80.0f, 45.0f));
		System.out.println(as.build());

//		UrlCharge url = new UrlCharge();

		sc.close();
	}

	public static float random(float min, float max) {
		return Math.round(min + ((max - min) * Math.random()));
	}

}
