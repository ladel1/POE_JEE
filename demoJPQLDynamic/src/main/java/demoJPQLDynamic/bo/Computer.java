package demoJPQLDynamic.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="computers")
public class Computer implements Serializable {

	// la config
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;	
	private String cpu;
	private String ram;
	private String hardDisk;
	private String gpu;
	private String motherBoard;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Computer(String nom, String cpu, String ram, String hardDisk, String gpu, String motherBoard) {
		this.nom = nom;
		this.cpu = cpu;
		this.ram = ram;
		this.hardDisk = hardDisk;
		this.gpu = gpu;
		this.motherBoard = motherBoard;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", cpu=" + cpu + ", ram=" + ram + ", hardDisk=" + hardDisk + ", gpu=" + gpu
				+ ", motherBoard=" + motherBoard + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
