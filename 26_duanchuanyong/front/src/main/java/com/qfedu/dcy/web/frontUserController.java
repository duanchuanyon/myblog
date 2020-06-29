package com.qfedu.dcy.web;

import com.qfedu.dcy.service.frontUserService;
import com.qfedu.dcy.utils.Data;
import com.qfedu.dcy.entity.GUserEntity;
import com.qfedu.dcy.pojo.GUserPojo;
import com.qfedu.dcy.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class frontUserController {

    @Autowired
    frontUserService fus;
    //注册
    @RequestMapping("/register")
    public Object register(GUserPojo gup,HttpServletRequest request){
        Data data = new Data();
        //用户非空判断
        if (StringUtil.isEmpty(gup.getEmail())
                && StringUtil.isEmpty(gup.getName())
                && StringUtil.isEmpty(gup.getPassword())){
            data.setCode(-1);
            return data;
        }
        //获取图片保存位置
        String image = (String) request.getSession().getAttribute("image");
        //用户没有上传头像
        if(image==null){
            data.setCode(-1);
            return data;
        }
        //用户上传头像
        gup.setImage(image);
        boolean addResult=fus.addFrontUser(gup);

        if (addResult){
            //添加成功
            data.setCode(1);
        }else {
            data.setCode(-1);
        }
        return data;
    }

    //用户校验,判断邮箱唯一性
    @RequestMapping("/read")
    public Object read(GUserPojo gup){
        Data data = new Data();
        //用户非空判断,邮箱不为空时
        if (StringUtil.isEmpty(gup.getEmail())){
            data.setCode(-1);
            return data;
        }
        GUserEntity readResult=fus.readFrontUser(gup);
        if (readResult!=null){
            //查询结果
            data.setCode(1);
        }else {
            data.setCode(-1);
        }
        return data;
    }

    //前端用户登录
    @RequestMapping("/frontUserLogin")
    public Object frontUserLogin(GUserPojo gup){
        Data data = new Data();
        //用户非空判断,邮箱不为空时
        if (StringUtil.isEmpty(gup.getEmail())&&StringUtil.isEmpty(gup.getPassword())){
            data.setCode(-1);
            return data;
        }
        GUserEntity readResult=fus.frontUser(gup);
        if (readResult!=null){
            //查询结果
            data.setCode(1);
        }else {
            data.setCode(-1);
        }
        return data;
    }

    //查询用户信息
    @RequestMapping("/select")
    public Object select(GUserPojo gup){
        if (gup.getEmail()==null || gup.getEmail().trim()==""){
            Data data = new Data();
            data.setCode(-1);
            return data;
        }
        GUserEntity readResult=fus.readFrontUser(gup);
        //添加成功
        return readResult;
    }

    //图片上传
    @RequestMapping("/imageUpload")
    public Data imageUpload(MultipartFile img, HttpServletRequest request) throws IOException {
        String imgname=img.getOriginalFilename();
        Data data = new Data();
        //判断文件类型
        if (imgname.endsWith(".gif")||imgname.endsWith(".png")){
            //构建文件路径;构建文件名称
            String filename = System.currentTimeMillis()+ img.getOriginalFilename();
            //文件的路径: 获取当前项目发布的真实路径
            String realPath = request.getSession().getServletContext().getRealPath("upload");
            File file = new File(realPath);
            String path= realPath+File.separator+filename;

            //System.out.println("文件保存路径:"+path);
            if(!file.exists()){//说明文件夹不存在
                file.mkdir(); //文件夹不存在就创建一个目录
            }
            img.transferTo(new File(path));
            //上传成功
            data.setCode(1);
            path=File.separator+path.substring(path.indexOf("upload"));
            request.getSession().setAttribute("image",path);
            return data;
        }else {
            data.setCode(-1);
            return data;
        }
    }

    //图片下载
    @RequestMapping("/download")
    public void downloadImage(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
        //1:得到服务器的文件,以及文件路径
        String path = request.getSession().getServletContext().getRealPath("upload")+File.separator+fileName;
        response.setContentType("application/force-download");//MIME类型
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        System.out.println(path);
        FileInputStream fis=null;
        ServletOutputStream os=null;
        try {
            //2:构建一个输入流
            fis = new FileInputStream(path);
            //3:得到一个输出流
            os = response.getOutputStream();

            FileCopyUtils.copy(fis, os);//将服务器的图片传送到用户
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //关闭通道
            if (fis != null) {
                fis.close();
            }
            os.flush();
            os.close();
        }
    }
}
