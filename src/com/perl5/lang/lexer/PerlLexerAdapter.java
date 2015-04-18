package com.perl5.lang.lexer;

/**
 * Created by hurricup on 12.04.2015.
 */
import com.intellij.lexer.FlexAdapter;
import com.perl5.lang.lexer.ported.Toke;

import java.io.Reader;

public class PerlLexerAdapter extends FlexAdapter {
	public PerlLexerAdapter() {
		super(new Toke((Reader) null));
	}
}