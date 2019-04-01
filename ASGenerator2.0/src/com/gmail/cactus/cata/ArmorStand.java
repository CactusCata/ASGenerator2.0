package com.gmail.cactus.cata;

import java.util.HashMap;

public class ArmorStand extends Main{
	private HashMap<DataTag, Integer> tags = new HashMap<>();
	private HashMap<RotationType, Float[]> rotations = new HashMap<>();
	private float rotation;

	public void setDataTag(DataTag tag, int value) {
		tags.put(tag, value);
	}

	public void setRotation(RotationType type, float x, float y) {
		rotations.put(type, new Float[] { x, y, 0f });
	}
	
	public void setRotation(float rotation)
	{
		this.rotation = rotation; 
	}

	public String build() {
		String build = new String();

		build += "/colorcommand /summon ArmorStand ~ ~0.5 ~ ";
		build += "{";

		for (DataTag tag : tags.keySet()) {
			int value = tags.get(tag);

			build += tag.name() + ":" + value + "b,";
		}

		build += "Equipment:[{id:\"minecraft:potato\",Count:1b,tag:{display:{Name:\"&5&k!&r&3&l[&6&lSuper Anniv de la Patate&3&l]&5&k!&r\",Lore:[\"&bAllez tous sur son profil et &4&oSPAMMER BON ANNIV&b :D&r\",\"&e&lCollectez le plus de &6&lpatate &e&lavant la fin de l'event !!&r\"]},ench:[{id:-1,lvl:1}]}},{id:\"minecraft:leather_boots\",tag:{display:{color:13557796},ench:[{id:-1,lvl:1}]}},{id:\"minecraft:leather_leggings\",tag:{display:{color:11583263},ench:[{id:-1,lvl:1}]}},{id:\"minecraft:leather_chestplate\",tag:{display:{color:13557796}}},{id:\"minecraft:skull\",Damage:3,tag:{SkullOwner:VBT_Killhawk}}],";

		build += "Rotation:[" + rotation + "],";

		build += "Pose:{";

		for (RotationType rotation : rotations.keySet()) {
			Float[] values = rotations.get(rotation);
			float xRot = values[0];
			float yRot = values[1];
			float zRot = values[2];

			build += rotation.getParam() + ":[" + xRot + "f," + yRot + "f," + zRot + "f],";
		}

		build += "}";

		build += "}";

		return build;
	}

	public enum DataTag {
		NoGravity, Invisible, ShowArms, Small, NoBasePlate, Invulnerable, PersistenceRequired, CustomNameVisible, DisabledSlots;
	}

	public enum RotationType {
		Rotation("Rotation"), HEAD("Head"), LEFT_LEG("LeftLeg"), RIGHT_LEG("RightLeg"), LEFT_ARM("LeftArm"), RIGHT_ARM(
				"RightArm");

		private String param;

		private RotationType(String param) {
			this.param = param;
		}

		public String getParam() {
			return param;
		}
	}
}
