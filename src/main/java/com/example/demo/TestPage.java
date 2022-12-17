package com.example.demo;

import com.example.demo.components.CodeBlocksFactory;
import com.example.demo.components.ToolsPanel;
import com.example.demo.components.blocks.RootCodeBlock;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/")
@CssImport("./styles/styles.css")
public class TestPage extends VerticalLayout {

    final RootCodeBlock rootCodeBlock = new RootCodeBlock(new CodeBlocksFactory());

    public TestPage() {
        add(new ToolsPanel(toolsButtonDragStartEvent -> {
            rootCodeBlock.highlightDropTarget();
        }, toolsButtonDragEndEvent -> {
            rootCodeBlock.unhighlightDropTarget();
        }), rootCodeBlock);
    }
}
