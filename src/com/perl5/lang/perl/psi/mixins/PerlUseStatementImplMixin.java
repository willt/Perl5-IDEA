/*
 * Copyright 2015 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.psi.mixins;

import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.perl5.lang.perl.psi.PerlNamespaceElement;
import com.perl5.lang.perl.psi.PsiPerlUseStatement;
import com.perl5.lang.perl.psi.impl.PerlStringContentElementImpl;
import com.perl5.lang.perl.psi.impl.PsiPerlStatementImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hurricup on 31.05.2015.
 */
public abstract class PerlUseStatementImplMixin extends PsiPerlStatementImpl implements PsiPerlUseStatement
{
	public PerlUseStatementImplMixin(ASTNode node)
	{
		super(node);
	}

	@Override
	public boolean isUseParent()
	{
		return "parent".equals(getPackageName());
	}

	@Override
	public boolean isUseBase()
	{
		return "base".equals(getPackageName());
	}

	@Override
	public String getPackageName()
	{
		PerlNamespaceElement ns = getNamespaceElement();
		if (ns != null)
			return ns.getName();
		return null;
	}

	@Override
	public PerlNamespaceElement getNamespaceElement()
	{
		return findChildByClass(PerlNamespaceElement.class);
	}

	@Override
	public List<String> getStringParameters()
	{
		List<String> stringParameters = new ArrayList<>();
		for (PerlStringContentElementImpl stringContentElement : PsiTreeUtil.findChildrenOfType(this, PerlStringContentElementImpl.class))
			stringParameters.add(stringContentElement.getText());
		return stringParameters;
	}
}
