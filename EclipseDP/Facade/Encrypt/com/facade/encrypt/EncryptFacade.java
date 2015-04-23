package com.facade.encrypt;

public class EncryptFacade {
	
	private FileReader fileReader;
	private FileWritter fileWritter;
	private CipherMachine cipherMachine;
	
	public EncryptFacade() {
		fileReader = new FileReader();
		fileWritter = new FileWritter();
		cipherMachine = new CipherMachine();
	}
	
	public void fileEncrypt(String fileNameSrc, String fileNameDes){
		String plainText = fileReader.read(fileNameSrc);
		String cipherText = cipherMachine.encrypt(plainText);
		fileWritter.write(cipherText, fileNameDes);
	}
	

}
