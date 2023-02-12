import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	ArrayList<Staffs> staff = new ArrayList<>();
	
	public static String getIdA() {
	    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String randStr = "";
	    Random rnd = new Random(System.currentTimeMillis());
	    char[] text = new char[2];
	    for(int i=0; i<2; i++) {
	    	text[i] = chars.charAt(rnd.nextInt(chars.length()));
	    }
	    for(int i=0; i<text.length; i++) {
	    	randStr+=text[i];
	    }
	    return randStr;
	}
	
	public static String getIdNum() {
	    String chars = "0123456789";
	    String randStr = "";
	    Random rnd = new Random(System.currentTimeMillis());
	    char[] text = new char[4];
	    for(int i=0; i<4; i++) {
	    	text[i] = chars.charAt(rnd.nextInt(chars.length()));
	    }
	    for(int i=0; i<text.length; i++) {
	    	randStr+=text[i];
	    }
	    return randStr;
	}
	
	public static void sort(ArrayList<Staffs> pog) {
        pog.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
	
	public Main() {
		int choice, wage=0;
		String id, name, gender, job;
		ArrayList<String> idManager = new ArrayList<>();
		ArrayList<String> idSupervisor = new ArrayList<>();
		ArrayList<String> idAdmin = new ArrayList<>();
		String[] yes = {"No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan"};
		
		do{
			for(int i=0; i<5; i++) System.out.println();
			System.out.println("Data Karyawan PT Meksiko\n");
			System.out.println("1. Tambah Data Karyawan");
			System.out.println("2. Tampilkan Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan\n");
			System.out.print(">> ");
			choice = sc.nextInt();
			sc.nextLine();
			for(int i=0; i<5; i++) System.out.println();
			if(choice==1) {
				do {
					System.out.print("Input nama karyawan [>=3]: ");
					name=sc.nextLine();
				}while(name.length()<3);
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					gender=sc.nextLine();
				}while(gender.equals("Laki-laki") == false && gender.equals("Perempuan") == false);
				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					job=sc.nextLine();
				}while(job.equals("Manager") == false && job.equals("Supervisor") == false && job.equals("Admin") == false);
				id= getIdA() + "-" + getIdNum();
				System.out.println("Berhasil menambahkan karyawan dengan id "+ id);
				
				if(job.equals("Manager") == true) {
					wage = 8000000;
					idManager.add(id);
					if(idManager.size()<2) {}
					else if(idManager.size()%3==1) {
						for(int i=0; i<idManager.size()-1; i++) {
							for(int j=0; j<staff.size(); j++) {
								if(idManager.get(i).equals(staff.get(j).getId())==true) {
									staff.get(j).setWage(staff.get(j).getWage()*110/100);
									break;
								}
							}
						}
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
						for(int i=0; i<idManager.size()-1; i++) {
							System.out.print(idManager.get(i) +" ");
						}
						System.out.println();
					}
				}
				if(job.equals("Supervisor") == true) {
					wage = 6000000;
					idSupervisor.add(id);
					if(idSupervisor.size()<2) {}
					else if(idSupervisor.size()%3==1) {
						for(int i=0; i<idSupervisor.size()-1; i++) {
							for(int j=0; j<staff.size(); j++) {
								if(idSupervisor.get(i).equals(staff.get(j).getId())==true) {
									staff.get(j).setWage((staff.get(j).getWage()*75/1000)+staff.get(j).getWage());
									break;
								}
							}
						}
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
						for(int i=0; i<idSupervisor.size()-1; i++) {
							System.out.print(idSupervisor.get(i) +" ");
						}
						System.out.println();
					}
				}
				if(job.equals("Admin") == true) {
					wage = 4000000;
					idAdmin.add(id);
					if(idAdmin.size()<2) {}
					else if(idAdmin.size()%3==1) {
						for(int i=0; i<idAdmin.size()-1; i++) {
							for(int j=0; j<staff.size(); j++) {
								if(idAdmin.get(i).equals(staff.get(j).getId())==true) {
									staff.get(j).setWage(staff.get(j).getWage()*105/100);
									break;
								}
							}
						}
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
						for(int i=0; i<idAdmin.size()-1; i++) {
							System.out.print(idAdmin.get(i) +" ");						
						}
						System.out.println();
					}
				}
				staff.add(new Staffs(id, name, gender, job, wage));
				System.out.println("ENTER to return");
				sc.nextLine();
			}
			else if(choice==2) { 
				if(staff.isEmpty() == true) {
					System.out.println("Data Masih Kosong!\n");
					System.out.println("Tekan [ENTER] untuk kembali");
					sc.nextLine();
					continue;
				}
				sort(staff);
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n", yes[0], yes[1], yes[2], yes[3], yes[4], yes[5]);
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				for(int i=0; i<staff.size(); i++) {
					System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n", i+1, staff.get(i).getId(), staff.get(i).getName(), staff.get(i).getGender(), staff.get(i).getJob(), staff.get(i).getWage());
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
				System.out.println("Tekan [ENTER] untuk kembali");
				sc.nextLine();
				
			}
			else if(choice==3) {
				if(staff.isEmpty() == true) {
					System.out.println("Data Masih Kosong!\n");
					System.out.println("Tekan [ENTER] untuk kembali");
					sc.nextLine();
					continue;
				}
				sort(staff);
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n", yes[0], yes[1], yes[2], yes[3], yes[4], yes[5]);
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				for(int i=0; i<staff.size(); i++) {
					System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n", i+1, staff.get(i).getId(), staff.get(i).getName(), staff.get(i).getGender(), staff.get(i).getJob(), staff.get(i).getWage());
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
				System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
				choice=sc.nextInt();
				sc.nextLine();
				do {
					System.out.print("Input nama karyawan [>=3]: ");
					name=sc.nextLine();
					if(name.equals("0")==true) break;
					else staff.get(choice-1).setName(name);
				}while(name.length()<3);
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					gender=sc.nextLine();
					if(gender.equals("0")==true) break;
					else staff.get(choice-1).setGender(gender);
				}while(gender.equals("Laki-laki") == false && gender.equals("Perempuan") == false);
				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					job=sc.nextLine();
					if(job.equals("0")==true) break;
					else {
						if(staff.get(choice-1).getJob().equals("Manager") == true) {
							for(int i=0; i<idManager.size(); i++) {
								if(idManager.get(i).equals(staff.get(choice-1).getId())) {
									idManager.remove(i);
								}
							}
						}
						if(staff.get(choice-1).getJob().equals("Supervisor") == true) {
							for(int i=0; i<idSupervisor.size(); i++) {
								if(idSupervisor.get(i).equals(staff.get(choice-1).getId())) {
									idSupervisor.remove(i);
								}
							}
						}
						if(staff.get(choice-1).getJob().equals("Admin") == true) {
							for(int i=0; i<idAdmin.size(); i++) {
								if(idAdmin.get(i).equals(staff.get(choice-1).getId())) {
									idAdmin.remove(i);
								}
							}
						}
						staff.get(choice-1).setJob(job);
						if(job.equals("Manager") == true) {
							idManager.add(staff.get(choice-1).getId());
							if(staff.get(choice-1).getWage() < 8000000) {
								staff.get(choice-1).setWage(8000000);
							}
							if(idManager.size()<2) {}
							else if(idManager.size()%3==1) {
								for(int i=0; i<idManager.size()-1; i++) {
									for(int j=0; j<staff.size(); j++) {
										if(idManager.get(i).equals(staff.get(j).getId())==true) {
											staff.get(j).setWage(staff.get(j).getWage()*110/100);
											break;
										}
									}
								}
								System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
								for(int i=0; i<idManager.size()-1; i++) {
									System.out.print(idManager.get(i) +" ");
								}
								System.out.println();
							}
						}
						if(job.equals("Supervisor") == true) {
							idSupervisor.add(staff.get(choice-1).getId());
							if(staff.get(choice-1).getWage() < 6000000) {
								staff.get(choice-1).setWage(6000000);
							}
							if(idSupervisor.size()<2) {}
							else if(idSupervisor.size()%3==1) {
								for(int i=0; i<idSupervisor.size()-1; i++) {
									for(int j=0; j<staff.size(); j++) {
										if(idSupervisor.get(i).equals(staff.get(j).getId())==true) {
											staff.get(j).setWage((staff.get(j).getWage()*75/1000)+staff.get(j).getWage());
											break;
										}
									}
								}
								System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
								for(int i=0; i<idSupervisor.size()-1; i++) {
									System.out.print(idSupervisor.get(i) +" ");
								}
								System.out.println();
							}
						}
						if(job.equals("Admin") == true) {
							idAdmin.add(staff.get(choice-1).getId());
							if(idAdmin.size()<2) {}
							else if(idAdmin.size()%3==1) {
								for(int i=0; i<idAdmin.size()-1; i++) {
									for(int j=0; j<staff.size(); j++) {
										if(idAdmin.get(i).equals(staff.get(j).getId())==true) {
											staff.get(j).setWage(staff.get(j).getWage()*105/100);
											break;
										}
									}
								}
								System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
								for(int i=0; i<idAdmin.size()-1; i++) {
									System.out.print(idAdmin.get(i) +" ");						
								}
								System.out.println();
							}
						}
					}
					
				}while(job.equals("Manager") == false && job.equals("Supervisor") == false && job.equals("Admin") == false);
				
				
			}
			else if(choice==4) {
				if(staff.isEmpty() == true) {
					System.out.println("Data Masih Kosong!\n");
					System.out.println("Tekan [ENTER] untuk kembali");
					sc.nextLine();
					continue;
				}
				sort(staff);
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n", yes[0], yes[1], yes[2], yes[3], yes[4], yes[5]);
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				for(int i=0; i<staff.size(); i++) {
					System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n", i+1, staff.get(i).getId(), staff.get(i).getName(), staff.get(i).getGender(), staff.get(i).getJob(), staff.get(i).getWage());
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
				System.out.print("Imput nomor urutan karyawan yang ingin dihapus: ");
				choice=sc.nextInt();
				sc.nextLine();
				System.out.println("Karyawan dengan kode " + staff.get(choice-1).getId() + " berhasil dihapus");
				if(staff.get(choice-1).getJob().equals("Manager")) {
					for(int i=0; i<idManager.size(); i++) {
						if(idManager.get(i).equals(staff.get(choice-1).getId())) {
							idManager.remove(i);
						}
					}
				}
				if(staff.get(choice-1).getJob().equals("Supervisor")) {
					for(int i=0; i<idSupervisor.size(); i++) {
						if(idSupervisor.get(i).equals(staff.get(choice-1).getId())) {
							idSupervisor.remove(i);
						}
					}
				}
				if(staff.get(choice-1).getJob().equals("Admin")) {
					for(int i=0; i<idAdmin.size(); i++) {
						if(idAdmin.get(i).equals(staff.get(choice-1).getId())) {
							idAdmin.remove(i);
						}
					}
				}
				staff.remove(choice-1);
				System.out.println("ENTER to return");
				sc.nextLine();
			}
		}while(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
