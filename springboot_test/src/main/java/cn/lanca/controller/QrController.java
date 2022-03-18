package cn.lanca.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/18 10:09  <br>
 */
@RestController
@RequestMapping("/qr_code")
public class QrController {


    /**
     * 通过传入参数获取qrcode，二维码内容不支持中文字符
     *
     * @param args     二维码中的信息
     * @param response mvc请求返回对象
     * @throws WriterException 异常
     * @throws IOException     异常
     */
    @GetMapping("/{args}")
    public void getQrCode(@PathVariable("args") String args, HttpServletResponse response) throws WriterException, IOException {
        // postman测试

        response.setContentType("image/png");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //
        int width = 450;
        int height = 450;
        if (outputStream != null) {
            BitMatrix bitMatrix = qrCodeWriter.encode(args, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            outputStream.flush();
            outputStream.close();
        }
    }
}
