package faca.training.Spring_ToolEnglish.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class IrregularVerbs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String english;
	@Column(columnDefinition = "nvarchar(250)")
	private String vietnamese;
	@Column(columnDefinition = "nvarchar(250)")
	private String phienam;
	private String p1;
	@Column(columnDefinition = "nvarchar(250)")
	private String phienamp1;
	private String p2;
	@Column(columnDefinition = "nvarchar(250)")
	private String phienamp2;
	@Column(columnDefinition = "nvarchar(250)")
	private String amthanh;
	@Column(columnDefinition = "nvarchar(250)")
	private String amthanhp1;
	@Column(columnDefinition = "nvarchar(250)")
	private String amthanhp2;
	private String dahoc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getVietnamese() {
		return vietnamese;
	}
	public void setVietnamese(String vietnamese) {
		this.vietnamese = vietnamese;
	}
	public String getPhienam() {
		return phienam;
	}
	public void setPhienam(String phienam) {
		this.phienam = phienam;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getPhienamp1() {
		return phienamp1;
	}
	public void setPhienamp1(String phienamp1) {
		this.phienamp1 = phienamp1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	public String getPhienamp2() {
		return phienamp2;
	}
	public void setPhienamp2(String phienamp2) {
		this.phienamp2 = phienamp2;
	}
	public String getAmthanh() {
		return amthanh;
	}
	public void setAmthanh(String amthanh) {
		this.amthanh = amthanh;
	}
	public String getDahoc() {
		return dahoc;
	}
	public void setDahoc(String dahoc) {
		this.dahoc = dahoc;
	}
	
	public String getAmthanhp1() {
		return amthanhp1;
	}
	public void setAmthanhp1(String amthanhp1) {
		this.amthanhp1 = amthanhp1;
	}
	public String getAmthanhp2() {
		return amthanhp2;
	}
	public void setAmthanhp2(String amthanhp2) {
		this.amthanhp2 = amthanhp2;
	}

	public IrregularVerbs(String english, String vietnamese, String phienam, String p1, String phienamp1, String p2,
			String phienamp2, String amthanh, String amthanhp1, String amthanhp2, String dahoc) {
		super();
		this.english = english;
		this.vietnamese = vietnamese;
		this.phienam = phienam;
		this.p1 = p1;
		this.phienamp1 = phienamp1;
		this.p2 = p2;
		this.phienamp2 = phienamp2;
		this.amthanh = amthanh;
		this.amthanhp1 = amthanhp1;
		this.amthanhp2 = amthanhp2;
		this.dahoc = dahoc;
	}
	public IrregularVerbs() {
		super();
	}
	
}
