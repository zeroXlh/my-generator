package com.zero.my_generator;

import java.math.BigDecimal;
import java.util.Objects;

public class CalcDemo {
	public static void main(String[] args) {

		Hero huamulan = new Hero(1, "花木兰", 7, 7, 7, 14,
				new HeroHaloAddition(BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.5),
						BigDecimal.valueOf(0.5)),
				new HeroBeautifulAddition(BigDecimal.valueOf(3), BigDecimal.valueOf(3), BigDecimal.valueOf(3),
						BigDecimal.valueOf(3)));
		Hero zhurong = new Hero(1, "祝融", 20, 5, 5, 5, new HeroHaloAddition(BigDecimal.valueOf(1.6), null, null, null),
				new HeroBeautifulAddition(BigDecimal.valueOf(3), BigDecimal.valueOf(3), BigDecimal.valueOf(3),
						BigDecimal.valueOf(3)));
		// Hero huamulan = new Hero(1, "花木兰", 7, 7, 7, 7);
		System.out.println(huamulan + ": " + huamulan.result());
		System.out.println(zhurong + ": " + zhurong.result());
	}
}

class HeroHaloAddition {
	private BigDecimal powerAddition;

	private BigDecimal intellectAddition;
	private BigDecimal politicsAddition;
	private BigDecimal charmAddition;

	public HeroHaloAddition(BigDecimal powerAddition, BigDecimal intellectAddition, BigDecimal politicsAddition,
			BigDecimal charmAddition) {
		super();
		this.powerAddition = powerAddition;
		this.intellectAddition = intellectAddition;
		this.politicsAddition = politicsAddition;
		this.charmAddition = charmAddition;
	}

	public BigDecimal getPowerAddition() {
		return powerAddition;
	}

	public void setPowerAddition(BigDecimal powerAddition) {
		this.powerAddition = powerAddition;
	}

	public BigDecimal getIntellectAddition() {
		return intellectAddition;
	}

	public void setIntellectAddition(BigDecimal intellectAddition) {
		this.intellectAddition = intellectAddition;
	}

	public BigDecimal getPoliticsAddition() {
		return politicsAddition;
	}

	public void setPoliticsAddition(BigDecimal politicsAddition) {
		this.politicsAddition = politicsAddition;
	}

	public BigDecimal getCharmAddition() {
		return charmAddition;
	}

	public void setCharmAddition(BigDecimal charmAddition) {
		this.charmAddition = charmAddition;
	}

	@Override
	public String toString() {
		return "HeroHaloAddition [powerAddition=" + powerAddition + ", intellectAddition=" + intellectAddition
				+ ", politicsAddition=" + politicsAddition + ", charmAddition=" + charmAddition + "]";
	}

}

class HeroBeautifulAddition {
	private BigDecimal powerAddition;

	private BigDecimal intellectAddition;
	private BigDecimal politicsAddition;
	private BigDecimal charmAddition;

	public HeroBeautifulAddition(BigDecimal powerAddition, BigDecimal intellectAddition, BigDecimal politicsAddition,
			BigDecimal charmAddition) {
		super();
		this.powerAddition = powerAddition;
		this.intellectAddition = intellectAddition;
		this.politicsAddition = politicsAddition;
		this.charmAddition = charmAddition;
	}

	public BigDecimal getPowerAddition() {
		return powerAddition;
	}

	public void setPowerAddition(BigDecimal powerAddition) {
		this.powerAddition = powerAddition;
	}

	public BigDecimal getIntellectAddition() {
		return intellectAddition;
	}

	public void setIntellectAddition(BigDecimal intellectAddition) {
		this.intellectAddition = intellectAddition;
	}

	public BigDecimal getPoliticsAddition() {
		return politicsAddition;
	}

	public void setPoliticsAddition(BigDecimal politicsAddition) {
		this.politicsAddition = politicsAddition;
	}

	public BigDecimal getCharmAddition() {
		return charmAddition;
	}

	public void setCharmAddition(BigDecimal charmAddition) {
		this.charmAddition = charmAddition;
	}

	@Override
	public String toString() {
		return "HeroBeautifulAddition [powerAddition=" + powerAddition + ", intellectAddition=" + intellectAddition
				+ ", politicsAddition=" + politicsAddition + ", charmAddition=" + charmAddition + "]";
	}

}

class Hero {
	private Integer id;

	private String name;

	private Integer power;

	private Integer intellect;

	private Integer politics;

	private Integer charm;

	private HeroHaloAddition haloAddition;

	private HeroBeautifulAddition beautifulAddition;

	public Hero(Integer id, String name, Integer power, Integer intellect, Integer politics, Integer charm) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.intellect = intellect;
		this.politics = politics;
		this.charm = charm;
	}

	public Hero(Integer id, String name, Integer power, Integer intellect, Integer politics, Integer charm,
			HeroHaloAddition haloAddition, HeroBeautifulAddition beautifulAddition) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.intellect = intellect;
		this.politics = politics;
		this.charm = charm;
		this.haloAddition = haloAddition;
		this.beautifulAddition = beautifulAddition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getIntellect() {
		return intellect;
	}

	public void setIntellect(Integer intellect) {
		this.intellect = intellect;
	}

	public Integer getPolitics() {
		return politics;
	}

	public void setPolitics(Integer politics) {
		this.politics = politics;
	}

	public Integer getCharm() {
		return charm;
	}

	public void setCharm(Integer charm) {
		this.charm = charm;
	}

	public BigDecimal result() {
		BigDecimal result = BigDecimal.valueOf(0);
		result = result.add(BigDecimal.valueOf(power)).add(BigDecimal.valueOf(intellect))
				.add(BigDecimal.valueOf(politics)).add(BigDecimal.valueOf(charm));

		// 佳人加成
		BigDecimal powerBeaAdd = BigDecimal.valueOf(power).multiply(beautifulAddition.getPowerAddition());
		BigDecimal intellectBeaAdd = BigDecimal.valueOf(intellect).multiply(beautifulAddition.getIntellectAddition());
		BigDecimal politicsBeaAdd = BigDecimal.valueOf(politics).multiply(beautifulAddition.getPoliticsAddition());
		BigDecimal charmBeaAdd = BigDecimal.valueOf(charm).multiply(beautifulAddition.getCharmAddition());

		System.out.println(this + "佳人加成: 武力-" + powerBeaAdd + "，智力-" + intellectBeaAdd + "，政治-" + politicsBeaAdd
				+ "，魅力-" + charmBeaAdd);
		result = result.add(powerBeaAdd).add(intellectBeaAdd).add(politicsBeaAdd).add(charmBeaAdd);

		// 光环加成
		if (null != haloAddition.getPowerAddition()) {
			BigDecimal powerHaloAdd = BigDecimal.valueOf(power).add(powerBeaAdd)
					.multiply(haloAddition.getPowerAddition());
			result = result.add(powerHaloAdd);
			System.out.println(this + "光环武力加成: " + powerHaloAdd);
		}
		if (Objects.nonNull(haloAddition.getIntellectAddition())) {
			BigDecimal intellectHaloAdd = BigDecimal.valueOf(intellect).add(intellectBeaAdd)
					.multiply(haloAddition.getIntellectAddition());
			result = result.add(intellectHaloAdd);
			System.out.println(this + "光环智力加成: " + intellectHaloAdd);
		}
		if (Objects.nonNull(haloAddition.getPoliticsAddition())) {
			BigDecimal politicsHaloAdd = BigDecimal.valueOf(politics).add(politicsBeaAdd)
					.multiply(haloAddition.getPoliticsAddition());
			result = result.add(politicsHaloAdd);
			System.out.println(this + "光环政治加成: " + politicsHaloAdd);
		}
		if (Objects.nonNull(haloAddition.getCharmAddition())) {
			BigDecimal charmHaloAdd = BigDecimal.valueOf(charm).add(charmBeaAdd)
					.multiply(haloAddition.getCharmAddition());
			System.out.println(this + "光环魅力加成: " + charmHaloAdd);
			result = result.add(charmHaloAdd);
		}

		return result;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + "]";
	}

}