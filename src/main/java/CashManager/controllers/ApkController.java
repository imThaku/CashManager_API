package CashManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class ApkController {

    private static final String DIRECTORY = "./files/";
    private static final String FILE = "cashmanager.apk";

    /**
     * Download the CashManager application apk
     * @return 200
     * @throws IOException
     */
    @GetMapping("/client.apk")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadApp() throws IOException {
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;

        File file = new File(DIRECTORY + FILE);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + FILE)
                // Content-Type
                .contentType(mediaType)
                // Content-Length
                .contentLength(file.length()) //
                .body(resource);
    }

    @GetMapping("/client_alt.apk")
    public void downloadFile3(HttpServletResponse response) throws IOException {
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
        File file = new File(DIRECTORY + FILE);

        // Content-Type
        // application/pdf
        response.setContentType(mediaType.getType());

        // Content-Disposition
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());

        // Content-Length
        response.setContentLength((int) file.length());

        BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        outStream.flush();
        inStream.close();
    }

}
