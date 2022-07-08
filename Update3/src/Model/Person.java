package Model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Person implements Serializable {

	public enum Preference {
		WorkEarlier, WorkLater, WorkWithoutChange, WorkFromHome
	}

	protected String name, id;
	protected Preference preference;

	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		preference = Preference.WorkWithoutChange;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return this.name.equals(p.getName()) && this.id.equals(p.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Id: " + id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	public String getId() {
		return id;
	}

}
