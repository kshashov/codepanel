package com.example.demo.components.blocks;

import com.example.demo.components.CodeBlocksFactory;

public class SlottedCodeBlock extends CodeBlock {

    public SlottedCodeBlock(CodeBlocksFactory codePanelFactory) {
        super(codePanelFactory);
        addDropSlot();
    }
}
