package com.example.demo.components.blocks;

import com.example.demo.components.CodeBlocksFactory;
import com.example.demo.components.Operator;
import lombok.Getter;

public class OperatorCodeBlock extends SlottedCodeBlock {
    @Getter
    private final Operator operator;

    public OperatorCodeBlock(CodeBlocksFactory codePanelFactory, Operator operator) {
        super(codePanelFactory);
        this.operator = operator;
        setText(operator.name());
    }
}
