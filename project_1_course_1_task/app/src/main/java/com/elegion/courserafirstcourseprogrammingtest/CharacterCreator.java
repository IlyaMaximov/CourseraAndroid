package com.elegion.courserafirstcourseprogrammingtest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class CharacterCreator extends Observable  implements Serializable{

    public enum Specialization {
        WARRIOR, ARCHER, MAGE
    }

    public enum Race {
        HUMAN, ELF, ORC, DWARF
    }

    public enum Attribute {
        STRENGTH, AGILITY, INTELLECT, STAMINA, LUCK
    }

    public enum Perk {
        BERSERK, CALM, LIGHTWEIGHT, HEAVYARMORED, OBSERVANT, MEDITATIONS
    }

    private String mName;
    private Specialization mSpecialization;
    private Race mRace;
    private int mAvailablePoints;

    private Map<String, Integer> mAttributesMap = new HashMap<>();
    private Map<String, Boolean> mPerksMap = new HashMap<>();


    public CharacterCreator() {
        mRace = Race.HUMAN;
        mSpecialization = Specialization.WARRIOR;
        mAvailablePoints = 5;
        mAttributesMap.put(Attribute.STRENGTH.name(), 5);
        mAttributesMap.put(Attribute.AGILITY.name(), 5);
        mAttributesMap.put(Attribute.INTELLECT.name(), 5);
        mAttributesMap.put(Attribute.STAMINA.name(), 5);
        mAttributesMap.put(Attribute.LUCK.name(), 5);
    }

    private String toTitleString(String title) {
        return title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
    }

    private <T extends Enum<T>> String[] enumValuesToStringArray(T[] eValues) {
        String[] stringArray = new String[eValues.length];
        for (int i = 0; i < eValues.length; ++i) {
            stringArray[i] = toTitleString(eValues[i].name());
        }
        return stringArray;
    }

    public String[] getSpecializations() {
        return enumValuesToStringArray(Specialization.values());
    }

    public void setSpecialization(int position) {
        if (position <= 0) {
            mSpecialization = Specialization.WARRIOR;
        } else if (position == 1) {
            mSpecialization = Specialization.ARCHER;
        } else {
            mSpecialization = Specialization.MAGE;
        }
    }

    public String[] getRaces() {
        return enumValuesToStringArray(Race.values());
    }

    public void setRace(int position) {
        if (position <= 0) {
            mRace = Race.HUMAN;
        } else if (position == 1) {
            mRace = Race.ELF;
        } else if (position == 2) {
            mRace = Race.ORC;
        } else {
            mRace = Race.DWARF;
        }
    }

    public String[] getAttributes() {
        return enumValuesToStringArray(Attribute.values());
    }

    public String[] getPerks() {
        return enumValuesToStringArray(Perk.values());
    }

    public void updateAttributeValue(int position, int updateTo) {
        if (position < 0 || position > Attribute.values().length) {
            throw new RuntimeException("Position does not match any of the attributes");
        }
        Attribute attribute = Attribute.values()[position];
        Integer attributeValue = mAttributesMap.get(attribute.name());

        if (updateTo > 0 && mAvailablePoints >= updateTo || updateTo < 0 && attributeValue + updateTo > 0) {
            mAvailablePoints -= updateTo;
            mAttributesMap.put(attribute.name(), attributeValue + updateTo);
        }
        setChanged();
        notifyObservers();
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvailablePoints() {
        return String.valueOf(mAvailablePoints);
    }

    public Map<String, Integer> getAttributesMap() {
        return mAttributesMap;
    }

    public void checkPerk(String text, boolean isChecked) {
        mPerksMap.put(text, isChecked);
    }

    public Character create() {
        Character character = new Character();
        character.setName(mName);
        character.setRace(mRace);
        character.setSpecialization(mSpecialization);
        character.setAttributes(mAttributesMap);
        character.setPerks(mPerksMap);
        character.calculateParameters();
        return character;
    }

    public Specialization getSpecialization() {
        return mSpecialization;
    }

    public Race getRace() {
        return mRace;
    }

    public Map<String, Boolean> getPerksMap() {
        return mPerksMap;
    }

    public void setAvailablePoints(int availablePoints) {
        mAvailablePoints = availablePoints;
    }

    public int getRacePosition() {
        return mRace.ordinal();
    }

    public int getSpecializationPosition() {
        return mSpecialization.ordinal();
    }
}
