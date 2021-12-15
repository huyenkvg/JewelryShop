package ptithcm.controller;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.bean.BasePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/mailer/")
public class MailerController {
	@RequestMapping("form")
	public String index() {
		return "mailer/form";
	}

	@Autowired
	JavaMailSender mailer;
	@Autowired
	BasePath basePath;
	
	static String duongdan = new File("src").getAbsolutePath();

	@RequestMapping("send")
	public String send(ModelMap model, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("subject") String subject, @RequestParam("body") String body) {
		try {
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);

			mailer.send(mail);
			model.addAttribute("message", "Gá»­i email thÃ nh cÃ´ng!");
		} catch (Exception e) {
			model.addAttribute("message", "Gá»­i email tháº¥t báº¡i!");
			// TODO: handle exception
		}
		return "mailer/form";
	}

	public boolean guiMailTaiKhoanNhanVien(String from, String to, String subject, String body,
			JavaMailSender mmailer) {
		try {
			MimeMessage mail = mmailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);
			mmailer.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String createPassword() {
		String s = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		String ans = "";
		for (int i = 0; i < 6; i++) {
			Random rand = new Random();
			int ranNum = rand.nextInt(62);
			ans += s.charAt(ranNum);
		}
		return ans;
	}

	public String createIDFromName(String nameOfSomething) {
		String s = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		String ans = "";

		for (int i = 0; i < 6; i++) {
			Random rand = new Random();
			int ranNum = rand.nextInt(62);
			ans += s.charAt(ranNum);
		}
		return ans;
	}

	public static int saveProductPhoto( String productID, MultipartFile photo, BasePath bp) {
		Date date = java.util.Calendar.getInstance().getTime();
		if (photo.isEmpty()) {
			return 0;
		} else {
			try {
				String photoPath =  bp.getPathName() + File.separator +productID+ "-" + getDsPhoto(productID).size()+".jpg";
				photo.transferTo(new File(photoPath));

				Thread.sleep(2000);

				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static int saveNhanVienPhoto( String productID, MultipartFile photo, BasePath bp) {
		Date date = java.util.Calendar.getInstance().getTime();
		if (photo.isEmpty()) {
			return 0;
		} else {
			try {
				String photoPath =  bp.getPathName() + File.separator +productID+".jpg";
				photo.transferTo(new File(photoPath));
				
				Thread.sleep(2000);
				
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static List<String> getDsPhoto(String productID) {
		//new File("src\\main\\java\\ptithcm\\controller\\MailerController.java").getAbsolutePath()
//		File folder = new File(duongdan + "\\main\\webapp\\assets\\Images\\SanPham");
		File folder = new File("C:\\Users\\HUYENKUTE\\Desktop\\DoAn_TiemKimHoan\\src\\main\\webapp\\assets\\Images\\SanPham");
		FileFilter fileFilter = new WildcardFileFilter("*.JPG", IOCase.INSENSITIVE); 
		
		File[] listOfFiles = folder.listFiles(fileFilter);
		if(listOfFiles == null)
				return null;
		List<String> arrays = new ArrayList<String>();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			String s=listOfFiles[i].getName();
//			System.out.println(s.split("-")[0] + "   : "+productID);
			if(s.split("-")[0].equals(productID))
				arrays.add(s);
			
		}
		return arrays;
	}
	public static String getPhotoNhanVien(String ID) {
//		File folder = new File(duongdan + "\\main\\webapp\\assets\\Images\\SanPham");
		File folder = new File("C:\\Users\\HUYENKUTE\\Desktop\\DoAn_TiemKimHoan\\src\\main\\webapp\\assets\\Images\\NhanVien");
		
		FileFilter fileFilter = new WildcardFileFilter("*.JPG", IOCase.INSENSITIVE); 
		
		File[] listOfFiles = folder.listFiles(fileFilter);
		if(listOfFiles == null)
			return null;
		List<String> arrays = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			String s=listOfFiles[i].getName();
			if(s.equals(ID))
				arrays.add(s);
			
		}
		if(arrays.isEmpty()) return null;
		return arrays.get(0);
	}
	public static void main(String[] args) {
		System.out.println(new File("src").getAbsolutePath());
	}
}
