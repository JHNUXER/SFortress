class Term:
  textBuffer = [""]
  cursorPos = [0,0]
  
  def write(text):
    textBuffer[textBuffer.length-1]+=text
  def newLine():
    textBuffer[textBuffer.length] = ""
  def writeLine(text):
    write(text)
    newLine()
  def clear():
    textBuffer = [""]
  def setCursorPos(x,y):
    self.cursorPos = [x,y]
  def getCursorPos():
    return self.cursorPos
