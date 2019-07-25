package com.kzw.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kzw.utils.ServletUtils;

@Controller
@RequestMapping("/file")
public class FileAction {
	
	private String upload;
	
	@PostConstruct
	public void init() {
		try {
			String path = this.getClass().getResource("/").toURI().getPath();
			File dir = new File(path, "../upload").getCanonicalFile();
			if(!dir.exists() && !dir.isDirectory()) {
				dir.mkdir();
			}
			upload = dir.getCanonicalPath();
			System.out.println(upload);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 一次上传多个文件（name相同）
	 * */
	@RequestMapping("upload1")
	public String upload1(String uname, @RequestParam("file1") MultipartFile[] files) {
		
		System.out.println(uname);
		
		// 文件上传
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) continue; //没有选择文件
			
			long len = mf.getSize();
			String fname = mf.getOriginalFilename(); //文件名称
			System.out.println(fname + ": " + len);
			
			try {
				// 文件的读写
				mf.transferTo(new File(upload, fname));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "hello";
	}
	
	@RequestMapping("upload2")
	public String upload2(String uname, HttpServletRequest request) {
		
		System.out.println(uname);
		
		MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
		Map<String, MultipartFile> fileMap = req.getFileMap();
		Collection<MultipartFile> files = fileMap.values();
		
		// 文件上传
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) continue; //没有选择文件
			
			long len = mf.getSize();
			String fname = mf.getOriginalFilename(); //文件名称
			System.out.println(fname + ": " + len);
			
			try {
				// 文件的读写
				mf.transferTo(new File(upload, fname));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "hello";
	}
	
	/**
	 * 文件列表
	 * */
	@RequestMapping("list")
	public String list(Model model) {
		String[] fnames = new File(upload).list();
		model.addAttribute("fnames", fnames);
		return "file_list";
	}
	
	/**
	 * 文件下载
	 * */
	@RequestMapping("download")
	public void download(String fname, HttpServletResponse resp) throws Exception {
		// System.out.println(fname);
		fname = URLDecoder.decode(fname, "UTF-8");
		System.out.println(fname);
		
		// 设置响应头信息
		ServletUtils.setFileDownloadHeader(resp, fname);
		
		// 文件流的读写
		FileInputStream fis = new FileInputStream(new File(upload, fname));
		OutputStream os = resp.getOutputStream();
		byte[] buf = new byte[1024];
		int len;
		while((len=fis.read(buf)) > 0) {
			os.write(buf, 0, len);
		}
		os.flush();
		fis.close();
	}
}
