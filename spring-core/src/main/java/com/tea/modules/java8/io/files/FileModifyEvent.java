package com.tea.modules.java8.io.files;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.io.File;

/**
 * com.tea.modules.java8.io.files
 *
 * @author jaymin
 * @since 2021/7/10
 */
@Getter
@Setter
public class FileModifyEvent extends ApplicationEvent {
    /**
     * 被修改的文件
     */
    private File modifyFile;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public FileModifyEvent(File source) {
        super(source);
        this.modifyFile = source;
    }
}
