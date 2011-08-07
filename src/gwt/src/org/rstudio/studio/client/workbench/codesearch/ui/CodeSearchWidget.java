package org.rstudio.studio.client.workbench.codesearch.ui;



import org.rstudio.core.client.widget.SearchDisplay;
import org.rstudio.core.client.widget.SearchWidget;
import org.rstudio.core.client.widget.TextBoxWithCue;
import org.rstudio.studio.client.workbench.codesearch.CodeSearch;
import org.rstudio.studio.client.workbench.codesearch.CodeSearchOracle;
import org.rstudio.studio.client.workbench.commands.Commands;

import com.google.gwt.user.client.ui.SuggestBox;
import com.google.inject.Inject;


public class CodeSearchWidget extends SearchWidget 
                              implements CodeSearch.Display
{
   @Inject
   public CodeSearchWidget(CodeSearchOracle oracle,
                           final Commands commands)
   {
      super(oracle, 
            new TextBoxWithCue("Go to file/function"), 
            new SuggestBox.DefaultSuggestionDisplay());
      
      oracle_ = oracle;   
      
      CodeSearchResources res = CodeSearchResources.INSTANCE;
      
      setIcon(res.gotoFunction());       
      
      addStyleName(res.styles().codeSearchWidget());
   }

   @Override
   public SearchDisplay getSearchDisplay()
   {
      return this;
   }
   
   @Override
   public void setCueText(String text)
   {
      ((TextBoxWithCue)getTextBox()).setCueText(text);
   }
   
   @Override
   public CodeSearchOracle getSearchOracle()
   {
      return oracle_;
   }
   
   private final CodeSearchOracle oracle_;

  
}
