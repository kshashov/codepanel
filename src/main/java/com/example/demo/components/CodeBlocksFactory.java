package com.example.demo.components;

import com.example.demo.components.blocks.CodeBlock;
import com.example.demo.components.blocks.OperatorCodeBlock;
import com.example.demo.components.blocks.VarCodeRow;

public class CodeBlocksFactory {

    public CodeBlock byOperator(Operator operator) {
        switch (operator) {
            case VAR:
                return new VarCodeRow(this);
            default:
                return new OperatorCodeBlock(this, operator);
        }
    }
}
