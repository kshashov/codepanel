package com.example.demo.components.blocks;

import com.example.demo.components.CodeBlocksFactory;
import com.vaadin.flow.component.Tag;

@Tag("root-code-block")
public class RootCodeBlock extends CodeBlock {

    public RootCodeBlock(CodeBlocksFactory codeBlocksFactory) {
        super(codeBlocksFactory);

        addDropSlot();
    }

    public void highlightDropTarget() {
        getElement().setAttribute("drag", true);
    }

    public void unhighlightDropTarget() {
        getElement().setAttribute("drag", false);
    }
}
