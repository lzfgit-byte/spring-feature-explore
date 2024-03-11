package com.ilzf.poi.controller;

import com.ilzf.poi.util.PdfConverUtil;
import com.ilzf.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xslf.usermodel.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Api("测试POI")
@RestController("/")
public class IndexController {
    /**
     * 将后缀为.pptx的PPT转换为图片
     *
     * @param pptFile PPT的路径
     * @param imgFile 将PPT转换为图片后的路径
     */
    public void doPPT2007toImage(File pptFile, String imgFile) {
        List<String> list = new ArrayList<>();
        FileInputStream is = null;
        try {
            is = new FileInputStream(pptFile);

            XMLSlideShow xmlSlideShow = new XMLSlideShow(is);
            is.close();
            // 获取大小
            Dimension pgsize = xmlSlideShow.getPageSize();
            // 获取幻灯片
            List<XSLFSlide> slides = xmlSlideShow.getSlides();

            for (int i = 0; i < slides.size(); i++) {
                // 解决乱码问题
                List<XSLFShape> shapes1 = slides.get(i).getShapes();
                for (XSLFShape shape : shapes1) {

                    if (shape instanceof XSLFTextShape) {
                        XSLFTextShape sh = (XSLFTextShape) shape;
                        List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();

                        for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
                            List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
                            for (XSLFTextRun xslfTextRun : textRuns) {
                                xslfTextRun.setFontFamily("宋体");
                            }
                        }
                    }
                }
                //根据幻灯片大小生成图片
                BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();

                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));

                // 最核心的代码
                slides.get(i).draw(graphics);

                //图片将要存放的路径
                String absolutePath = imgFile + "/" + (i + 1) + ".jpeg";
                File jpegFile = new File(absolutePath);
                // 图片路径存放
                list.add((i + 1) + ".jpeg");
                //如果图片存在，则不再生成
                if (jpegFile.exists()) {
                    continue;
                }
                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(jpegFile);

                // 写入到图片中去
                ImageIO.write(img, "jpeg", out);
                out.close();
            }
            LogUtil.log("PPT转换成图片 成功！");
        } catch (Exception e) {
            LogUtil.log("PPT转换成图片 发生异常！{}" + e);
        }

    }


    @ApiOperation("pptx转图片")
    @GetMapping("/")
    public String index() {
        LogUtil.log("pdf转图片");
//        ZipSecureFile.setMinInflateRatio(-1.0d);
//        this.doPPT2007toImage(new File("C:\\Users\\18074\\Downloads\\picture.pptx"), "C:\\Users\\18074\\Downloads\\");

        return "pptx转图片";
    }

    @ApiOperation("pptx转pdf")
    @GetMapping("/index2")
    public String index2() {
        LogUtil.log("pptx转pdf");
        ZipSecureFile.setMinInflateRatio(-1.0d);
        PdfConverUtil.pptxToPdf("C:\\Users\\18074\\Downloads\\picture.pptx", "C:\\Users\\18074\\Downloads\\");

        return "pptx转pdf";
    }
}
