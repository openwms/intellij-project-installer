/*
 * Stamplets.
 *
 * This software module including the design and software principals used is and remains
 * the property of Heiko Scherrer (the initial authors of the project) with the understanding
 * that it is not to be reproduced nor copied in whole or in part, nor licensed or otherwise
 * provided or communicated to any third party without their prior written consent.
 * It must not be used in any way detrimental to the interests of the author.
 * Acceptance of this module will be construed as an agreement to the above. 
 *
 * All rights of Heiko Scherrer remain reserved.
 * Stamplets is an registered trademarks of Heiko Scherrer. Other products and company
 * names mentioned herein may be trademarks or trade names of the respective owner.
 * Specifications are subject to change without notice.
 */
package io.interface21;

import com.izforge.izpack.Pack;
import com.izforge.izpack.PackFile;
import com.izforge.izpack.event.InstallerListener;
import com.izforge.izpack.installer.AutomatedInstallData;
import com.izforge.izpack.util.AbstractUIProgressHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * A Zipper.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version 1.0
 * @since 1.0
 */
public class Zipper implements InstallerListener {
    @Override
    public void beforePacks(AutomatedInstallData automatedInstallData, Integer integer, AbstractUIProgressHandler abstractUIProgressHandler) throws Exception {

    }

    @Override
    public void beforePack(Pack pack, Integer integer, AbstractUIProgressHandler abstractUIProgressHandler) throws Exception {

    }

    @Override
    public boolean isFileListener() {
        return false;
    }

    @Override
    public void beforeDir(File file, PackFile packFile) throws Exception {

    }

    @Override
    public void afterDir(File file, PackFile packFile) throws Exception {

    }

    @Override
    public void beforeFile(File file, PackFile packFile) throws Exception {

    }

    @Override
    public void afterFile(File file, PackFile packFile) throws Exception {

    }

    @Override
    public void afterPack(Pack pack, Integer integer, AbstractUIProgressHandler abstractUIProgressHandler) throws Exception {

    }

    @Override
    public void afterPacks(AutomatedInstallData automatedInstallData, AbstractUIProgressHandler abstractUIProgressHandler) throws Exception {
        byte[] buffer = new byte[1024];

        try {

            FileOutputStream fos = new FileOutputStream(automatedInstallData.getInstallPath() + "intellij-settings.jar");
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(Path p : Paths.get(automatedInstallData.getInstallPath())) {

                ZipEntry ze = new ZipEntry(p.getFileName().toString());
                try {
                    zos.putNextEntry(ze);
                    FileInputStream in = new FileInputStream(p.getFileName().toFile());

                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

            zos.closeEntry();

            //remember close it
            zos.close();

            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void afterInstallerInitialization(AutomatedInstallData automatedInstallData) throws Exception {

    }
}
