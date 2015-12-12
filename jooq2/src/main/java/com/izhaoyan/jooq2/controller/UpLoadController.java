package com.izhaoyan.jooq2.controller;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaoyan on 15-12-7.
 */
@Controller
public class UpLoadController {
    private String[] fileNames;
    private String allowSuffix = "jpg,png,gif,jpeg";
    private long allowSize = 2L;//允许文件大小
    private String fileName;

    @RequestMapping("/upload")
    public String index(){
     return "index";
    }


    public void upload(MultipartFile[] files, HttpServletRequest request) throws Exception {
        String destDir = "/home/zhaoyan";
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        try {
            fileNames = new String[files.length];
            int index = 0;
            for (MultipartFile file : files) {
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                int length = getAllowSuffix().indexOf(suffix);
                if (length == -1) {
                    throw new Exception("请上传允许格式的文件");
                }
                if (file.getSize() > getAllowSize()) {
                    throw new Exception("您上传的文件大小已经超出范围");
                }
                String realPath = request.getSession().getServletContext().getRealPath("/");
                File destFile = new File(realPath + destDir);
                if (!destFile.exists()) {
                    destFile.mkdirs();
                }
                String fileNameNew = getFileNameNew() + "." + suffix;//
                File f = new File(destFile.getAbsoluteFile() + "\\" + fileNameNew);
                file.transferTo(f);
                f.createNewFile();

                fileNames[index++] = basePath + destDir + fileNameNew;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping("/uploadHandler")
    @ResponseBody
    public ResponseEntity<String> uploadTest(){
        return new ResponseEntity<String>("the String ResponseBody with custom status code (403 Forbidden)",
                HttpStatus.OK);
    }

    /**
     *
     * <p class="detail">
     * 功能：文件上传
     * </p>
     * @author wangsheng
     * @date 2014年9月25日
     * @throws Exception
     */
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception {
        String destDir = "/home/zhaoyan/";
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            int length = getAllowSuffix().indexOf(suffix);
            if (length == -1) {
                throw new Exception("请上传允许格式的文件");
            }
//            if (file.getSize() > getAllowSize()) {
//                throw new Exception("您上传的文件大小已经超出范围");
//            }

            String realPath = request.getSession().getServletContext().getRealPath("/");
            File destFile = new File(realPath + destDir);
            if (!destFile.exists()) {
                destFile.mkdirs();
            }
            String fileNameNew = getFileNameNew() + "." + suffix;
            File f = new File(destFile.getAbsoluteFile() + "/" + fileNameNew);
            file.transferTo(f);
            fileName = f.getAbsolutePath()+File.separator+f.getName();
            return fileName;
        } catch (Exception e) {
//            return "{'code':'400','data':'"+e.getMessage()+"'}";
            return "{\"jsonrpc\" : \"2.0\", \"error\" : {\"code\": 102, \"message\": \""+e.getMessage()+"\"}, \"id\" : \"id\"}";
        }
    }

    /**
     *
     * <p class="detail">
     * 功能：重新命名文件
     * </p>
     * @author wangsheng
     * @date 2014年9月25日
     * @return
     */
    private String getFileNameNew(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date());
    }


    public String getAllowSuffix() {
        return allowSuffix;
    }

    public long getAllowSize() {
        return allowSize;
    }
}
