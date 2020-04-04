package io.github.tkaczenko.koatuuparser.service.local;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author Andrii Tkachenko
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class KoatuuLoader {
    public void downloadAndExtractZip(String url, String destination) throws IOException {
        String filePath = "%s/%s";

        String zipPath = String.format(filePath, destination, "koatuu.zip");
        downloadAndSave(url, zipPath);
        ZipFile zipFile = new ZipFile(zipPath);
        zipFile.extractAll(String.format(filePath, destination, ""));
    }

    private void downloadAndSave(String url, String destination) throws IOException {
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(destination);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}
