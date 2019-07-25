package bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyCollect {

	private String[] array;
	private List<String> list;
	private Set<String> set;
	private Map<String, Object> map;
	private Properties prop;
	private Properties prop2;

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public Properties getProp2() {
		return prop2;
	}

	public void setProp2(Properties prop2) {
		this.prop2 = prop2;
	}
}
